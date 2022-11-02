package graphic;

import java.awt.*;

public class Button {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    //TODO: Сделать поле image
    private String path;
    private String text;

    public Button(int x, int y,   String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }

    public void draw(Graphics2D g) {
        //TODO: АНалогично рисовать картинку
        DrawUtils.drawButton(g, this);
    }
    public boolean isBounds(int x,int y){
        return x>getX() && x<getX()+getSizeX() && y > getY() && y < getY()+getSizeY();
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }



}