public class Hiker {

    static final int elements[] = {1, 5, 10, 25};

    public static int answer(int money) {

        if (money <= 0) return 0;

        return internalChange(1, money);
    }

    private static int internalChange(int element, int money) {

        if (money == 0) return 1;

        if (money < element) return 0;

        if (money == element) return 1;

        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] >= element) {
                count += internalChange(elements[i], money - elements[i]);
            }
        }

        return count;
    }

    public static int internalChange3(int n, int money) {

        System.out.println(n);
        System.out.println(money);
        System.out.println();

        if( n == 0) return  0;

        if( money < 0) return  0;

        if( money ==0) return  1;


        return internalChange3(n-1, money) +
                internalChange3(n, money - elements[n-1]);

    }



    public static int internalChange2(int index, int money){


        System.out.println(index);
        System.out.println(money);
        System.out.println();

        if( money < 0) return 0;
        if( money == 0) return 1;

        if( index == elements.length) return 0;

        return internalChange2( index + 1, money ) +
                internalChange2( index, money - elements[index]);

    }


}
