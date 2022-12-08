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

    public void logMessage(Transaction transaction, Clock clock) throws LogFileNotDefinedException {
        if (log == null) {
            throw new LogFileNotDefinedException("Log file is not initialized");
        }
        LocalDateTime currentTime = LocalDateTime.now(clock);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        log.println(currentTime.format(formatter) + " "
                + transaction.getCommand() + " "
                + transaction.getAmount() + " "
                + transaction.getFinalBalance());
    }
}
