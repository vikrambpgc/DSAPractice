package com.vikrambpgc.Interviews;

public class ExecuteLongJob {
    
    private static class MyTask extends Thread {
        int i;
        boolean interuptTask = false;
        MyTask() {
        }
        public void run() {
            while(!interuptTask) {
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Thread task = new MyTask();
        task.start();
        
        Thread.sleep(500L);
        //task.interuptTask = true;
        
        task.join();
    }

}
