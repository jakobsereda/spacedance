package org.example.model;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A position in the game which is represented
 * by a unique id and a filepath to an image
 * displaying the position
 */
public class Position {
    private PositionID id;
    private String filepath;

    /**
     * Constructs a new position
     * 
     * @param filepath the filepath to image of given position
     *                 IMPORTANT! must be of form:
     *                     "app/src/main/resources/images/<num>.jpg"
     */
    public Position(String filepath) {
        this.filepath = filepath;
        try {
            setID();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructs a new position, with
     * a randomly generated filepath and id
     */
    public Position() {
        Random rand = new Random();
        int randomNum = 1 + rand.nextInt(6);
        this.filepath = "app/src/main/resources/images/" + randomNum + ".png";
        try {
            setID(randomNum);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the id of this position based
     * on its filepath
     * 
     * @exception Exception thrown if filepath has 
     *                      an invalid format
     */
    private void setID() throws Exception {
        Pattern pattern = Pattern.compile("images/(\\d+)\\.png");
        Matcher matcher = pattern.matcher(filepath);

        if (matcher.find()) {
            int imageNum = Integer.parseInt(matcher.group(1));
            setID(imageNum);
        } else {
            throw new IllegalArgumentException("Invalid filepath format.");
        }
    }

    /**
     * Sets the id based on the image number
     * 
     * @param imageNum the number extracted from 
     *                 filepath or randomly generated
     * @exception Exception thrown if imageNum is not
     *                      associated with a known ID
     */
    private void setID(int imageNum) throws Exception {
        switch (imageNum) {
            case 1:
                this.id = PositionID.Star;
                break;
            case 2:
                this.id = PositionID.Vertical;
                break;
            case 3:
                this.id = PositionID.Split;
                break;
            case 4:
                this.id = PositionID.Windmill;
                break;
            case 5:
                this.id = PositionID.Crab;
                break;
            case 6:
                this.id = PositionID.TPose;
                break;
            default:
                throw new IllegalArgumentException("Unexpected filepath!");
        }
    }

    /**
     * Getter for filepath
     * 
     * @return the filepath associated with this position
     */
    public String getFilePath() {
        return filepath;
    }

    /**
     * Getter for id
     * 
     * @return the id associated with this position
     */
    public PositionID getID() {
        return id;
    }
}
