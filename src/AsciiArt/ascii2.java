import java.util.Random;
public class ascii2 {
       
     public static final int MOUSE_WIDTH = 9;
    public static final int MOUSE_HEIGHT = 9;
    public static final int SODA_WIDTH = 14;
    public static final int SODA_HEIGHT = 14;
    public static final int SPACE_WIDTH = 120;

    static Random rand = new Random();
  public static void main(String[] args)throws InterruptedException{
     int shift = 0;
     int direction = 5;
    
    while (true){
      
        char[][] genart;
        if(rand.nextBoolean()){
            genart = getmouse();
        } else{
            genart = getsoda();
        }
        char[] space = getspace();

        for (int y = 0; y < genart[0].length; y++){
           for (int s = 0; s < Math.min(shift, SPACE_WIDTH); s++){
                System.out.print(space[s]);
            }
            for(int x = 0; x < genart.length; x++){
                System.out.print(genart[y][x]);
            } 
            
            System.out.println();
        }
        System.out.println();
        Thread.sleep(200);
        shift = shift + direction;
         if (shift > SPACE_WIDTH){
            direction = -5;

    } else if(shift ==0){
        direction = 5;
    }
    
}
   
//      while (true){
//      char[][] genart;
     
//         if(rand.nextBoolean()){
//         genart = getmouse();
//         } else{
//      genart = getsoda();
//    }
//    for (int y = 0; y < genart[0].length; y++){
//     for(int x = 0; x < genart.length; x++){
//         System.out.print(genart[y][x]);
//     } 
// System.out.println();

// }
   
//    System.out.println();
//     Thread.sleep(200);
// }
   
  }
  
    

   
//code to test individual images {
    // public static void main(String[] args){
    //     char[][] soda = getsoda();
    //      for (int y = 0; y < SODA_HEIGHT; y++) {
    //         for (int x = 0; x < SODA_WIDTH; x++) {
    //              System.out.print(soda[y][x]);
    //          }
    //         System.out.println();
    //      }
    //     }

     // public static void main(String[] args){
    //     char[][] MOUSE = getmouse();
    //      for (int y = 0; y < MOUSE_HEIGHT; y++) {
    //         for (int x = 0; x < MOUSE_WIDTH; x++) {
    //              System.out.print(MOUSE[y][x]);
    //          }
    //         System.out.println();
    //      }
    //     }
    
//}
    
  static char[][] getmouse() {
        char[][] img = new char[MOUSE_WIDTH][MOUSE_HEIGHT];
   
        for (int y = 0; y < MOUSE_HEIGHT; y++) {
            for (int x = 0; x < MOUSE_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        
    
       
        img[8][2] = '^';
        img[8][6] = '^';
        img[7][2] = '/';
        img[7][3] = '/';
        img[7][4] = '-';
        img[7][5] = '\\';
        img[7][6] = '\\';
        img[6][2] = '(';
        img[6][3] = '-';
        img[6][4] = '╥';
        img[6][5] = '-';
        img[6][6] = ')';
        img[6][3] = '-';
        img[6][4] = '╥';
        img[6][5] = '-';
        img[5][0] = '^';
        img[5][3] = '-';
        img[5][4] = '╥';
        img[5][5] = '-';
        img[5][8] = '^';
        img[4][0] = '/';
        img[4][1] = '(';
        img[4][7] = ')';
        img[4][8] = '\\';
        img[3][3] = '/';
        img[3][5] = '\\';
        img[2][2] = '(';
        img[2][3] = '@';
        img[2][4] = '^';
        img[2][5] = '@';
        img[2][6] = ')';
        img[1][2] = '●';
        img[1][3] = '-';
        img[1][4] = '-';
        img[1][5] = '-';
        img[1][6] = '●';


        return img;
    } 
    static char[] getspace() {
        char[] space = new char[SPACE_WIDTH];
       
            for (int i = 0; i < SPACE_WIDTH; i++){
                space[i] = ' ';
            }

        return space;
    }
    // sometimes you have to adapt to unexpected situations 
     static char[][] getsoda() {
      char[][] img2 = new char[SODA_WIDTH][SODA_HEIGHT];
        for (int y = 0; y < SODA_HEIGHT; y++) {
            for (int x = 0; x < SODA_WIDTH; x++) {
                img2[y][x] = ' ';
            }

        }
        img2[13][2] = '-';
        img2[13][3] = '-';
        img2[13][4] = '-';
        img2[13][5] = '-';
        img2[13][6] = '-';
        img2[13][7] = '-';
        img2[13][8] = '-';
        img2[12][1] = '(';
        img2[12][9] = ')';
        img2[11][0] = '(';
        img2[11][10] = ')';
        img2[10][0] = '!';
        img2[10][10] = '!';
        img2[9][0] = '!';
        img2[9][10] = '!';
        img2[8][0] = '!';
        img2[8][10] = '!';
        img2[7][0] = '!';
        img2[7][10] = '!';
        img2[6][0] = '(';
        img2[6][10] = ')';
        img2[5][1] = '(';
        img2[5][9] = ')';
        img2[4][2] = '-';
        img2[4][3] = '-';
        img2[4][4] = '-';
        img2[4][5] = '-';
        img2[4][6] = '-';
        img2[4][7] = '-';
        img2[4][8] = '-';
        img2[3][5] = '\\';
        img2[3][6] = '\\';
        img2[2][4] = '\\';
        img2[2][5] = '\\';
        img2[1][3] = '\\';
        img2[1][4] = '\\';
        img2[0][3] = '-';

        return img2;
     }
     
 }
 