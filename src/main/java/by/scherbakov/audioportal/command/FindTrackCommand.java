package by.scherbakov.audioportal.command;

import by.scherbakov.audioportal.entity.AudioTrack;
import by.scherbakov.audioportal.logic.AudioTrackLogic;
import by.scherbakov.audioportal.manager.ConfigurationManager;
import by.scherbakov.audioportal.manager.MessageManager;
import by.scherbakov.audioportal.servlet.SessionRequestContent;

/**
 * Class {@code FindTrackCommand} is used to find track
 *
 * @author ScherbakovIlia
 * @see ActionCommand
 */


public class FindTrackCommand implements ActionCommand {
    private static final String SIGN_IN_ATTRIBUTE = "isSignIn";
    private static final String SIGN_IN_VALUE = "true";
    private static final String LOGIN_PAGE = "path.page.login";
    private static final String TRACK_NAME_ATTRIBUTE = "findText";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String MISTAKE_ATTRIBUTE = "mistakeSongName";
    private static final String TRACK_PAGE = "/web?command=track_info&track=";
    private static final String MAIN_PAGE_ACTION = "/web?command=main";
    private static final String FIND_TRACK_MESSAGE = "message.main.findError";
    private static final String SPACE = " ";

    @Override
    public String execute(SessionRequestContent requestContent) {
        String page = null;
        String isSignIn = (String) requestContent.getSessionAttributeValue(SIGN_IN_ATTRIBUTE);
        if(SIGN_IN_VALUE.equals(isSignIn)) {
            String trackName = requestContent.getRequestParameterValue(TRACK_NAME_ATTRIBUTE);
            AudioTrackLogic audioTrackLogic = new AudioTrackLogic();
            AudioTrack audioTrack = audioTrackLogic.takeTrackByName(trackName);
            if (audioTrack == null) {
                String pageMessage = MessageManager.getMessage(FIND_TRACK_MESSAGE,
                        (String) requestContent.getSessionAttributeValue(LOCALE_ATTRIBUTE));
                String mistakeMessage = trackName + SPACE + pageMessage;
                requestContent.setRequestAttributeValue(MISTAKE_ATTRIBUTE, mistakeMessage);
                page = MAIN_PAGE_ACTION;
            } else {
                page = TRACK_PAGE + audioTrack.getId();
            }
        }else {
            page = ConfigurationManager.getProperty(LOGIN_PAGE);
        }
        return page;
    }
}
