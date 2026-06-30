public class Main {

    int num = 0;

    public static void main(String[] args) {
        Main main = new Main(); // Create an instance of the Main class

        while (true) {
            try {
                System.out.println("Times Ran " + main.num);
                ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", "notepad.exe");
                Process process = processBuilder.start();
                process.waitFor();

                main.num++; // Increment the value of num

                System.out.println("Lightspeed is Closed \n");

                Thread.sleep(1); // 1 milisecond
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
