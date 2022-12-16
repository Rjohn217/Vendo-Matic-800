package com.techelevator.logger;

import com.techelevator.model.Money;
import com.techelevator.model.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
    @Test
    void logMessageThrowsException() {
        assertThrowsExactly(RuntimeException.class, () -> new Logger(null).logMessage(null, Clock.systemUTC()));
    }

    @Test
    void defaultClockWorks() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Logger log = new Logger(pw);
        Clock clock = Clock.systemDefaultZone();
        log.logMessage(null);
        LocalDateTime currentTime = LocalDateTime.now(clock);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        assertEquals(currentTime.format(formatter) + " Invalid Transaction Data" + System.lineSeparator(), sw.toString());
    }

    @Test
    void nullValuesHandled() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Logger log = new Logger(pw);
        Instant start = Instant.parse("2019-01-01T12:00:00.00Z");
        Clock clock = Clock.fixed(start, ZoneId.of("UTC"));
        log.logMessage(null, clock);
        log.logMessage(
                new Transaction(null, new Money(0), new Money(0), null),
                clock
        );
        log.logMessage(
                new Transaction("", null, new Money(0), null),
                clock
        );
        log.logMessage(
                new Transaction("", new Money(0), null, null),
                clock
        );
        String lines = "01/01/2019 12:00:00 PM Invalid Transaction Data" + System.lineSeparator() +
                "01/01/2019 12:00:00 PM Invalid Transaction Data" + System.lineSeparator() +
                "01/01/2019 12:00:00 PM Invalid Transaction Data" + System.lineSeparator() +
                "01/01/2019 12:00:00 PM Invalid Transaction Data" + System.lineSeparator();
        assertEquals(lines, sw.toString());

    }

    @Test
    void logMessage() throws IOException {
        Instant start = Instant.parse("2019-01-01T12:00:00.00Z");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Logger log = new Logger(pw);
        log.logMessage(
                new Transaction("FEED MONEY:",
                        new Money(500),
                        new Money(500),
                        null),
                Clock.fixed(start, ZoneId.of("UTC")));
        log.logMessage(
                new Transaction("FEED MONEY:",
                        new Money(500),
                        new Money(1000),
                        null),
                Clock.fixed(start.plusSeconds(15), ZoneId.of("UTC")));
        log.logMessage(
                new Transaction("Crunchie B4",
                        new Money(175),
                        new Money(825),
                        null),
                Clock.fixed(start.plusSeconds(20), ZoneId.of("UTC")));
        log.logMessage(
                new Transaction("Cowtales B2",
                        new Money(150),
                        new Money(675),
                        null),
                Clock.fixed(start.plusSeconds(85), ZoneId.of("UTC")));
        log.logMessage(
                new Transaction("GIVE CHANGE:",
                        new Money(675),
                        new Money(0),
                        null),
                Clock.fixed(start.plusSeconds(95), ZoneId.of("UTC")));
        String logContents = "01/01/2019 12:00:00 PM FEED MONEY: $5.00 $5.00" + System.lineSeparator() +
                "01/01/2019 12:00:15 PM FEED MONEY: $5.00 $10.00" + System.lineSeparator() +
                "01/01/2019 12:00:20 PM Crunchie B4 $1.75 $8.25" + System.lineSeparator() +
                "01/01/2019 12:01:25 PM Cowtales B2 $1.50 $6.75" + System.lineSeparator() +
                "01/01/2019 12:01:35 PM GIVE CHANGE: $6.75 $0.00" + System.lineSeparator();
        assertEquals(logContents, sw.toString());
        pw.close();
        sw.close();
    }


}