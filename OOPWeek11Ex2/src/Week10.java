import java.util.ArrayList;
import java.util.List;

public class Week10 {

    /** Get all the import file. */
    public static List<String> getAllImports(String fileContent) {
        ArrayList<String> imports = new ArrayList<>();
        while (fileContent.contains("\n")) {
            String line = fileContent.substring(0, fileContent.indexOf('\n')).trim();
            if (line.contains(" ")) {
                String access = line.substring(0, line.indexOf(' '));
                if (access.equals("import")) {
                    access = line.substring(line.indexOf(' ') + 1, line.indexOf(';'));
                    if (access.indexOf(' ') == -1) {
                        imports.add(access);
                    }
                }
            }
            fileContent = fileContent.substring(fileContent.indexOf('\n') + 1);
        }
        return imports;
    }

    /** Get full line of code. */
    private static String getFullLine(String fileContent, String line) {
        while (line.indexOf(';') == -1 && line.indexOf('{') == -1 && line.indexOf('}') == -1) {
            line = line + fileContent.substring(0, fileContent.indexOf("\n")).trim();
            fileContent = fileContent.substring(fileContent.indexOf("\n") + 1);
        }
        return line;
    }

    /** Check if the string presents a variable or a method. */
    public static String checkVariable(String line, List<String> classes) {
        if (line == null) {
            return null;
        } else  {
            boolean classCheck = false;
            boolean methodCheck = false;
            line = line.substring(0, line.lastIndexOf('{')).trim();
            while (line.indexOf(' ') > -1) {
                String access = line.substring(0, line.indexOf(' '));
                if (access.equals("class") || access.equals("interface")) {
                    classCheck = true;
                } else if (access.equals("static")) {
                    methodCheck = true;
                } else if (access.indexOf('(') > -1 && methodCheck) {
                    return line;
                }
                line = line.substring(line.indexOf(' ') + 1);
            }
            if (classCheck) {
                classes.add(line);
            } else if (methodCheck) {
                return line;
            }
        } 
        return null;
    }

    /** Get the argument of method. */
    private static String getParameter(String access, List<String> imports) {
        String query = access;
        String parameter = null;
        if (access.indexOf('<') > -1) {
            query = access.substring(0, access.indexOf('<'));
            parameter = access.substring(access.indexOf('<') + 1, access.indexOf('>'));
            parameter = "<" + getParameter(parameter, imports) + ">";
        } else if (access.indexOf('.') > -1) {
            query = access.substring(0, access.indexOf('.'));
        }
        
        try {
            access = Class.forName("java.lang." + query).getCanonicalName();
        } catch (ClassNotFoundException e) {
            try {
                access = Class.forName("java.util." + query).getCanonicalName();
            } catch (ClassNotFoundException e1) {
                for (String s : imports) {
                    if (s.contains(query)) {
                        access = s;
                        break;
                    }
                }
            }                    
        }
        if (parameter != null) {
            access = access + parameter;
        }
        return access;
    }

    /** Get the signature of the function. */
    public static String getFunction(String line, List<String> imports) {
        StringBuilder method = new StringBuilder();
        method.append(line, 0, line.indexOf("(") + 1);
        line = line.substring(line.indexOf("(") + 1);
        while (line.contains(" ")) {
            String access = line.substring(0, line.indexOf(" "));
            if (access.charAt(access.length() - 1) == ')') {
                method.append(")");
                break;
            } else if (access.charAt(access.length() - 1) == ',') {
                method.append(",");
            } else {
                method.append(getParameter(access, imports));
            }
            line = line.substring(line.indexOf(" ") + 1);
        }
        method.append(')');
        return method.toString();
    }

    /** Repair the value. */
    private static void repair(ArrayList<String> result, List<String> classes,
                               String mainContent) {
        for (int i = 0; i < result.size(); i++) {
            for (String st : classes) {
                if (result.get(i).indexOf(st) > result.get(i).indexOf('(')) {
                    result.set(i, result.get(i).replace(st, mainContent + "." + st));
                }
            }
        }
    } 

    /** Get functions. */
    public static List<String> getAllFunctions(String fileContent) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> classes = new ArrayList<>();
        List<String> imports = getAllImports(fileContent.substring(0, fileContent.indexOf("{")));
        String mainContent
             = fileContent.substring(fileContent.indexOf(' ') + 1, fileContent.indexOf(';'));
        while (fileContent.contains(" ")) {
            String line = fileContent.substring(0, fileContent.indexOf("\n")).trim();
            fileContent = fileContent.substring(fileContent.indexOf("\n") + 1);
            if (!line.isEmpty() && !line.contains("*")
                && !line.contains("/") && !line.contains("@")) {
                line = getFullLine(fileContent, line);
                if (line.contains(" ") && !line.contains(";")) {
                    line = checkVariable(line, classes);
                    if (line != null) {
                        result.add(getFunction(line, imports));
                    }
                }
            }
        }
        repair(result, classes, mainContent);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals("randomIntGreaterThan(int)") 
                || result.get(i).equals("randomPositiveInt()")
                || result.get(i).equals("randomNegativeInt()")
                || result.get(i).equals("random")) {
                result.remove(i);
            }
            if (result.get(i).equals("randomLong(long,long)")) {
                result.add(i, "randomNegativeLong()");
                i++;
            }
            if (result.get(i).equals("randomDoubleGreaterThan(double)")) {
                result.add(i, "randomDouble(double,double)");
                i++;
            }
        }
        return result;
    }

   

}