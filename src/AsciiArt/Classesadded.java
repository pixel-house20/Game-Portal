
 
   package AsciiArt;

import java.util.Random;
import java.util.Scanner;

import Game.GameWriteable;

import java.util.Random;
public class Classesadded implements GameWriteable {


 static final int WIDTH = getTerminalWidth() - 1;
    static final int HEIGHT = 20;
    static Random rand = new Random();

    private int score = 0;

    @Override
    public String getGameName() {
        return "Ascii Art Rain";
    }

    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ASCII ART RAIN ===");
        System.out.println("Press ENTER to start");
        System.out.println("Type 'q' + ENTER anytime to quit\n");
        sc.nextLine();

        char[][] nextRows = new char[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            nextRows[i] = getSpace();
        }

        char[] prevRow = nextRows[0];

        // controls loop
        final boolean[] running = { true };

        // input thread (for quitting)
        Thread inputThread = new Thread(() -> {
            Scanner input = new Scanner(System.in);
            while (running[0]) {
                String line = input.nextLine();
                if (line.equalsIgnoreCase("q")) {
                    running[0] = false;
                }
            }
        });

        inputThread.start();

        try {
            while (running[0]) {

                for (int x = 0; x < WIDTH - 30; x += 30) {
                    if (rand.nextDouble() < 0.1 && isBlank(prevRow, x)) {
                        loadNextRowsWithImage(nextRows, x);
                        score++;
                    }
                }

                prevRow = nextRows[0];
                shiftRowsUp(nextRows);

                System.out.println(new String(nextRows[0]));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("\nGame interrupted.");
        }

        inputThread.interrupt();

        System.out.println("\nGame Over!");
        System.out.println("Final Score: " + score);
    }

    @Override
    public String getScore() {
        return String.valueOf(score);
    }

    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;

        try {
            return Integer.parseInt(score) > Integer.parseInt(currentHighScore);
        } catch (Exception e) {
            return true;
        }
    }
     private static void loadNextRowsWithImage(char[][] nextRows, int x) {
        char[][] art = getRandomArt();

        for (int y = 0; y < art.length && y < nextRows.length; y++) {
            for (int ix = 0; ix < art[0].length && x + ix < WIDTH; ix++) {
                char c = art[y][ix];
                if (c != ' ') {
                    nextRows[y][x + ix] = c;
                }
            }
        }
    }

    private static char[][] getRandomArt() {
        char[][][] arts = { getButterfly(), getCloud(), getElephant() };
        return arts[rand.nextInt(arts.length)];
    }

    private static boolean isBlank(char[] prevRow, int x) {
        for (int i = x; i < x + 30 && i < prevRow.length; i++) {
            if (prevRow[i] != ' ') return false;
        }
        return true;
    }

    private static void shiftRowsUp(char[][] nextRows) {
        for (int i = 1; i < nextRows.length; i++) {
            nextRows[i - 1] = nextRows[i];
        }
        nextRows[nextRows.length - 1] = emptyRow();
    }

    private static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) row[i] = ' ';
        return row;
    }

    static char[] getSpace() {
        char[] space = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) space[i] = ' ';
        return space;
    }

    //Grace L's cloud 
    static char[][] getCloud() {
        char[][] img = new char[13][12];
        for (int y = 0; y < 13; y++) {
            for (int x = 0; x < 12; x++) {
                img[y][x] = ' ';
            }
        }
     
        img[0][4] = '_';
        img[0][5] = '_';
        img[0][6] = '_';
        img[1][1] = '_';
        img[1][2] = '/';
        img[1][3] = '*';
        img[1][6] = '"';
        img[1][7] = ')';
        img[1][8] = '_';
        img[1][9] = '_';
        img[2][0] = '(';
        img[2][1] = '_';
        img[2][2] = '_';
        img[2][3] = '_';
        img[2][4] = '=';
        img[2][5] = '_';
        img[2][6] = '_';
        img[2][7] = '_';
        img[2][8] = '_';
        img[2][9] = '_';
        img[2][10] = ')';
        img[2][11] = ')';
        img[3][2] = ',';
        img[3][4] = ',';
        img[3][6] = ',';
        img[3][8] = ',';
        img[3][9] = ',';
        img[4][1] = ',';
        img[4][3] = ',';
        img[4][5] = ',';
        img[4][7] = ',';
        img[4][9] = ',';
        img[6][1] = '_';
        img[6][2] = '_';
        img[6][3] = '_';
        img[6][4] = '_';
        img[6][5] = '_';
        img[6][6] = '_';
        img[6][7] = '_';
        img[6][8] = '_';
        img[6][9] = '_';
        img[6][10] = '_';
        img[7][0] = '/';
        img[7][1] = '_';
        img[7][2] = '_';
        img[7][3] = '_';
        img[7][4] = '_';
        img[7][5] = '_';
        img[7][6] = '_';
        img[7][7] = '_';
        img[7][8] = '_';
        img[7][9] = '_';
        img[7][10] = '_';
        img[7][11] = '\\';
        img[8][0] = '|';
        img[8][11] = '|';
        img[9][0] = '|';
        img[9][1] = '{';
        img[9][2] = '}';
        img[9][4] = '{';
        img[9][5] = '}';
        img[9][7] = '{';
        img[9][8] = '}';
        img[9][10] = '{';
        img[9][11] = '}';
        img[10][0] = '|';
        img[10][5] = '_';
        img[10][11] = '|';
        img[11][0] = '|';
        img[11][1] = '_';
        img[11][2] = '_';
        img[11][3] = '_';
        img[11][4] = '|';
        img[11][5] = '_';
        img[11][6] = '|';
        img[11][7] = '_';
        img[11][8] = '_';
        img[11][9] = '_';
        img[11][10] = '_';
        img[11][11] = '|';
        img[12][7] = 'G';
        img[12][8] = 'r';
        img[12][9] = 'a';
        img[12][10] = 'c';
        img[12][11] = 'e';

        return img;
    }

        // Yiannis' Elephant 
       static char[][] getElephant() {
        char[][] img = new char[20][20];
        // fill with empty space
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][14] = '_';
        img[1][5] = '(';
        img[1][6] = ')';
        img[1][13] = '|';
        img[1][14] = '~';
        img[1][15] = '|';
        img[2][4] = '/';
        img[2][5] = '|';
        img[2][6] = '|';
        img[2][7] = '\\';
        img[2][13] = '|';
        img[2][14] = '~';
        img[2][15] = '|';
        img[2][10] = '_';
        img[2][11] = '_';
        img[3][5] = '/';
        img[3][6] = '\\';
        img[3][9] = '/';
        img[3][12] = '\\';
        img[3][13] = '~';
        img[3][14] = '~';
        img[3][15] = '~';
        img[3][16] = '\\';
        img[2][17] = '_';
        img[2][18] = '_';
        img[3][19] = '\\';
        img[4][3] = ',';
        img[4][4] = '-';
        img[4][5] = '-';
        img[4][6] = '-';
        img[4][7] = '-';
        img[4][8] = '(';
        img[4][13] = '-';
        img[4][15] = '-';
        img[4][19] = ')';
        img[5][2] = '/';
        img[5][18] = '/';
        img[6][1] = '/';
        img[6][3] = '|';
        img[6][12] = '(';
        img[6][13] = '\\';
        img[6][16] = '|';
        img[6][17] = '(';
        img[7][0] = '^';
        img[7][3] = '\\';
        img[7][0] = '^';
        img[7][7] = '/';
        img[7][8] = '_';
        img[7][9] = '_';
        img[7][10] = '\\';
        img[7][13] = '/';
        img[7][14] = '\\';
        img[7][16] = '|';
        img[8][4] = '|';
        img[8][5] = '_';
        img[8][6] = '_';
        img[8][7] = '|';
        img[8][10] = '|';
        img[8][11] = '_';
        img[8][12] = '_';
        img[8][13] = '|';
        img[8][14] = '-';
        img[8][15] = '"';

        return img;
    }
    
    
    
    //Cat's Butterfly 
      static char[][] getButterfly() {
        char[][]img=new char [15][15];
        for(int y=0; y<15; y++ ){
            for(int x=0;x<15;x++){
                img[x][y]=' ';
            }
        }
        //left wing
        img[1][5]='♥';
        img[1][6]='♥';
        img[1][10]='♥';
        img[1][11]='♥';

        img[2][4]='♥';
        img[2][7]='♥';
        img[2][9]='♥';
        img[2][12]='♥';

        img[3][4]='♥';
        img[3][6]='o';
        img [3][10]='o';
        img[3][12]='♥';
        img[3][8]='♥';

        img [4][5]='♥';
        img[4][8]='-';
        img[4][11]='♥';

        img[5][6]='♥';
        img[5][10]='♥';

        img [6][7]='♥';
        img [6][9]='♥';

        img[7][8]='♥';

        //right wing

        img[14][5]='♥';
        img[14][6]='♥';
        img[14][10]='♥';
        img[14][11]='♥';

        img[13][4]='♥';
        img[13][7]='♥';
        img[13][9]='♥';
        img[13][12]='♥';

        img[12][4]='♥';
        img[12][6]='o';
        img [12][10]='o';
        img[12][12]='♥';
        img[12][8]='♥';

        img [11][5]='♥';
        img[11][8]='-';
        img[11][11]='♥';

        img[10][6]='♥';
        img[10][10]='♥';

        img [9][7]='♥';
        img [9][9]='♥';

        img[8][8]='♥';

        return img;
    }

      static char[] getspace() {
        char[] space = new char[SPACE_WIDTH];
       
            for (int i = 0; i < SPACE_WIDTH; i++){
                space[i] = ' ';
            }

        return space;
    }
    
   

  public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; 
        }
    }

    private static int getUnixTerminalWidth() {
        try {
           
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); 
            }
        } catch (Exception ignored) {
        
        }
        return 80; 
    }

}




