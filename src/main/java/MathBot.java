import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.List;

public class MathBot extends TelegramLongPollingBot {
    UserExer userExer;
    int okCount;
    int erCount;

    public MathBot() {
        this.userExer = new UserExer();
    }

    public void onUpdateReceived(Update update) {
        try {
            //????????? ???? ?? ????????? ? ????????? ?? ???
            if (update.hasMessage() && update.getMessage().hasText()) {
                //????????? ?????? ????????? ?????????
                Message inMessage = update.getMessage();
                //??????? ????????? ?????????
                SendMessage outMessage = new SendMessage();
                //????????? ? ????? ??? ????? ?????????? ?????????
                //(? ??? ?? ???, ?????? ?????? ???????? ?????????)
                outMessage.setChatId(inMessage.getChatId());
                //????????? ????? ?????????
                outMessage.setText(inMessage.getText());
                //?????????? ?????????
                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdatesReceived(List<Update> updates) {
        try {
            if (updates.get(0).hasMessage() && updates.get(0).getMessage().hasText()) {

                Message inMessage = updates.get(0).getMessage();


                SendMessage outMessage = new SendMessage();

                outMessage.setChatId(inMessage.getChatId());

                GetChatMember getChatMember = new GetChatMember();
                getChatMember.setChatId(inMessage.getChatId());

                //int userId = getChatMember.getUserId();

                String answer = inMessage.getText();

                try {
                    if (Integer.parseInt(answer) == userExer.answer) {
                        okCount++;
                        execute(outMessage.setText(userExer.getExpression() + answer + " - OK. GREAT."));

                    } else {
                        erCount++;
                        execute(outMessage.setText(userExer.getExpression() + answer + " - ERROR"));

                    }

                    userExer = new UserExer();
                    outMessage.setText(userExer.getExpression() + "?");

                    execute(outMessage);
                }
                catch (Exception e)
                {
                    if (answer.equals("stat")) {
                        outMessage.setText("OK: "+okCount+"\nER: "+erCount);
                    }
                    else{
                        userExer = new UserExer();
                        outMessage.setText(userExer.getExpression() + "?");
                    }

                    execute(outMessage);
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "MathExercisesBot";
    }

    public String getBotToken() {
        return "1469023447:AAF-hWDIRFpuUHs3P2LcQCmgftanIaqLVM0";
    }



}
