package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    BotSocketThread botSocketThread = new BotSocketThread();

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            //super.processIncomingMessage(message);
            if (message != null) {
                Calendar calendar = Calendar.getInstance();
                ConsoleHelper.writeMessage(message);
                if (message.contains(": ")) {
                    String [] splittedMessage = message.split(": ");
                    if (splittedMessage.length == 2 && splittedMessage[1] != null) {
                        switch (splittedMessage[1]) {
                            case "дата":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("d.MM.YYYY").format(calendar.getTime()));
                                break;
                            case "день":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("d").format(calendar.getTime()));
                                break;
                            case "месяц":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("MMMM").format(calendar.getTime()));
                                break;
                            case "год":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("YYYY").format(calendar.getTime()));
                                break;
                            case "время":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("H:mm:ss").format(calendar.getTime()));
                                break;
                            case "час":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("H").format(calendar.getTime()));
                                break;
                            case "минуты":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("m").format(calendar.getTime()));
                                break;
                            case "секунды":
                                sendTextMessage("Информация для " + splittedMessage[0] + ": "
                                        + new SimpleDateFormat("s").format(calendar.getTime()));
                                break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }


}
