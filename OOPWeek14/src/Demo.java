public class Demo {
    public static void main(String[] args) {
////                                    james-hana
////                                    /           \
////                                ryan            kai-jenifer
////                                                /   / \    \
////                                            tom john mary linda-ben
//                                                              /  \
//                                                        chris       jane

        Person james = new Person("James", 1969, "male");
        Person hana = new Person("Hana", 1970, "female");
        Person ryan = new Person("Ryan", 1978, "male");
        Person kai = new Person("Kai", 1979, "male");
        Person jenifer = new Person("Jenifer", 1978, "female");
        Person tom = new Person("Tom", 1991, "male");
        Person john = new Person("John", 1991, "male");
        Person mary = new Person("Mary", 1991, "female");
        Person linda = new Person("Linda", 1996, "female");
        Person ben = new Person("Ben", 1967, "male");
        Person chris = new Person("Chris", 2010, "male");
        Person jane = new Person("jane", 2011, "female");


        james.marry(hana);
        james.addChildren(ryan);
        james.addChildren(kai);
        hana.addChildren(ryan);
        hana.addChildren(kai);

        kai.marry(jenifer);
        kai.addChildren(tom);
        kai.addChildren(john);
        kai.addChildren(mary);
        kai.addChildren(linda);
        jenifer.addChildren(tom);
        jenifer.addChildren(john);
        jenifer.addChildren(mary);
        jenifer.addChildren(linda);

        linda.marry(ben);
        linda.addChildren(chris);
        linda.addChildren(jane);
        ben.addChildren(chris);
        ben.addChildren(jane);


        FamilyTree familyTree = new FamilyTree();
        familyTree.add(james);
        familyTree.add(hana);
        familyTree.add(ryan);
        familyTree.add(kai);
        familyTree.add(jenifer);
        familyTree.add(tom);
        familyTree.add(john);
        familyTree.add(mary);
        familyTree.add(linda);
        familyTree.add(ben);
        familyTree.add(chris);
        familyTree.add(jane);

        System.out.println("#Test not married");
        System.out.println(familyTree.printNotMarried());

        System.out.println("#Test two children");
        System.out.println(familyTree.printTwoChildrenCouples());

        System.out.println("#Test youngest gen");
        System.out.println(familyTree.printYoungestGen());
    }
}
