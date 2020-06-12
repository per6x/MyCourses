package Solutions;

class SL2 {
    public static void main(String[] args) {
        // 1.
        int a = 2;
        int b = 5;
        int c = 7;
        int res; // Put result here

        res = a;

        if (res < b)
            res = b;
        if (res < c)
            res = c;

        // 2.
        // You can also just print them out instead of assigning them to a string
        String str2 = "";

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (j == i)
                    str2 += "*";
                else
                    str2 += " ";

                if (j == 4)
                    str2 += "\n";
            }

        // 3.
        String str3 = "";
        for (double i = 1.0; i <= 3.0; i = i + 0.5)
            str3 += i + " ";

        // 4.
        int sum = 0;

        for (int i = 0; i < 10; i++)
            sum += i;
    }
}
