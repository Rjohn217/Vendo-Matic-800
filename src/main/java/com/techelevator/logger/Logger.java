package com.techelevator.logger;

import com.techelevator.model.Transaction;

import java.io.File;
import java.io.PrintWriter;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private PrintWriter log;

    public Logger(PrintWriter log) {
        this.log = log;
    }

    public void logMessage(Transaction transaction) {
        logMessage(transaction, null);
    }

    public void logMessage(Transaction transaction, Clock clock) {
        if (log == null) {
            throw new RuntimeException("Log file is not initialized");
        }
        if (clock == null) {
            clock = Clock.systemDefaultZone();
        }
        LocalDateTime currentTime = LocalDateTime.now(clock);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        if (transaction == null || transaction.getCommand() == null
                || transaction.getAmount() == null || transaction.getFinalBalance() == null) {
            log.println(currentTime.format(formatter) + " Invalid Transaction Data");
            return;
        }
        log.println(currentTime.format(formatter) + " "
                + transaction.getCommand() + " "
                + transaction.getAmount() + " "
                + transaction.getFinalBalance());
    }
}
