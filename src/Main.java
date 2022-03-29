public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String...args){
        int n = 8;
        int m = 8;
        int p = 2;

        boolean [][] field = fillArray(n,m,p);

        for(int i = 0; i < field.length; i++){
            for(int j = 0; j<field[i].length; j++){
                if(field[i][j]){
                System.out.print(WHITE+"▀ "+RESET);
                }else {
                    if(countBomb(field,i,j)==0||countBomb(field,i,j)==7||countBomb(field,i,j)==8)
                        System.out.print(countBomb(field,i,j)+" ");
                    if(countBomb(field,i,j)==1)
                        System.out.print(BLUE+countBomb(field,i,j)+RESET+" ");
                    if(countBomb(field,i,j)==2)
                        System.out.print(GREEN+countBomb(field,i,j)+RESET+" ");
                    if(countBomb(field,i,j)==3)
                        System.out.print(RED+countBomb(field,i,j)+RESET+" ");
                    if(countBomb(field,i,j)==4)
                        System.out.print(PURPLE+countBomb(field,i,j)+RESET+" ");
                    if(countBomb(field,i,j)==5)
                        System.out.print(RED+countBomb(field,i,j)+RESET+" ");
                    if(countBomb(field,i,j)==6)
                        System.out.print(CYAN+countBomb(field,i,j)+RESET+" ");
                }
            }
            System.out.println();
        }

    }

    public static int countBomb(boolean[][] field, int i, int j){
        int countBomb = 0;
        boolean up = false,down = false, left = false, right = false,
                leftUp = false, rightUp = false, rightDown = false, leftDown = false;

        if(i-1>=0)
            up = field[i-1][j];
        if(j-1>=0)
            left = field[i][j-1];
        if(j+1<field[i].length)
            right = field[i][j+1];
        if(i+1<field.length)
            down = field[i+1][j];
        if(i-1>=0 && j+1<field[0].length)
            rightUp = field[i-1][j+1];
        if(i-1>=0 && j-1>=0)
            leftUp = field[i-1][j-1];
        if(i+1<field.length && j-1>=0)
            leftDown = field[i+1][j-1];
        if(i+1<field.length && j+1<field[0].length)
            rightDown = field[i+1][j+1];


        countBomb += right ? 1 : 0;
        countBomb += left ? 1 : 0;
        countBomb += down ? 1 : 0;
        countBomb += up ? 1 : 0;
        countBomb += leftUp ? 1 : 0;
        countBomb += leftDown ? 1 : 0;
        countBomb += rightUp ? 1 : 0;
        countBomb += rightDown ? 1 : 0;
        return countBomb;
    }
    
    public static boolean[][] fillArray(int n, int m, int p){
        boolean [][] field = new boolean[n][m];
        for(int i = 0; i <field.length; i++){
            for(int j = 0; j<field[i].length; j++){
                double rand = (Math.random()*p);
                if(rand>p/2.0){
                    field[i][j] = true;
                }else{
                    field[i][j] = false;
                }

            }
        }
        return field;
    }

}