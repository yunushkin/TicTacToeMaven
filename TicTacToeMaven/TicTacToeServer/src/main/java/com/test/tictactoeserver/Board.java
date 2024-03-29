/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.tictactoeserver;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author wolf
 */
public class Board {
    enum Type {
        X,
        O,
        NOT
    };
    public Board(){
        clear();
    }
    public void set(int row, int col, Type type) {
        if(row >= maxRow || row >= maxCol)
            throw new IllegalAccessError();
        desc[row][col] = type;
    }
    public Type get(int row, int col) {
        if(row >= maxRow || row >= maxCol)
            throw new IllegalAccessError();
        return desc[row][col];
    }
    public void clear() {
        for(int row = 0; row < maxRow; row++) {
            for(int col = 0; col < maxCol; col++) {
                desc[row][col] = Type.NOT;
            }
        }
    }
    private Type desc[][] = {
        {Type.NOT, Type.NOT, Type.NOT},
        {Type.NOT, Type.NOT, Type.NOT},
        {Type.NOT, Type.NOT, Type.NOT}
    };
    public final int maxCol = 3;
    public final int maxRow = 3;
}
