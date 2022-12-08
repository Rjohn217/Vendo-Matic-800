package com.techelevator.logger;

import com.techelevator.model.Transaction;

import java.io.PrintWriter;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static PrintWriter log;

    public static void logMessage(Transaction transaction, Clock clock) {
        LocalDateTime currentTime = LocalDateTime.now(clock);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        log.println(currentTime.format(formatter) + " "
                + transaction.getCommand() + " "
                + transaction.getAmount() + " "
                + transaction.getFinalBalance());
    }

    public static void setLog(PrintWriter logFile) {
        log = logFile;
    }
}
