public class Main {

    public static void main(String[] args) {

        Range r = new Range(-5, 5);


        //////////////////////////////RANGELIST/////////////////////////////
/*
      r.remove(0);
        r.remove(5);


        r.setDescending(false);
        for (int i : r) {
            System.out.println(i);
        }

        System.out.println("\nINVERTING\n");

        r.setDescending(true);
        for (int q : r) {
            System.out.println(q);
        }
*/

        //ignorar esta parte para já, olhem para baixo!
        ////////////////////////////////////////////////////////////////////


        //////////////////////////////RANGE////////////////////////////////
        r.setDescending(true);

        while (r.iterator().hasNext()) {
            int i = r.iterator().next();

            if (i == -5 || i ==3 || i == 5) {
                r.remove(i);
            }
            if (!(r.contains(i))) {
                System.out.println(i);
            }
        }
        ////////////////////////////////////////////////////////////////////

    }
}

