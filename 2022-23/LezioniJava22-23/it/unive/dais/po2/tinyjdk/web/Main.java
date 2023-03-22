package it.unive.dais.po2.tinyjdk.web;

public class Main {
   public static void main(String[] args) throws Exception {
        BasicHTTPServer srv = new BasicHTTPServer();

        srv.listen(6969);
        System.out.println("Server non bloccante");
        Thread.sleep(10000);
        srv.stop();
        System.out.println("Server fermato");
   } 
}
