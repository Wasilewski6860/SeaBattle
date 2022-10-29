package newGraphic;

import graphic.DrawUtils;

import java.awt.*;

public class Button {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private Color color;
    private String text;

    public Button(int x, int y, int sizeX, int sizeY, Color color, String text) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.color = color;
        this.text = text;
    }

    public void draw(Graphics g) {
        DrawUtils.drawButton(g, this.x, this.y, this.sizeX, this.sizeY, this.color, this.text);
    }
    public boolean isBounds(int x,int y){
        return x < getX() + getSizeX() / 2 &&
                x > getX() - getSizeX() / 2 &&
                y < getY() + getSizeY() / 2 &&
                y > getY() - getSizeY() / 2;
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

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }



}

