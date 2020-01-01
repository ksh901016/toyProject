package com.corn.toy.simple.bind;

import com.corn.toy.simple.constants.Level;

import java.beans.PropertyEditorSupport;

public class LevelPropertyEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        return String.valueOf(((Level)this.getValue()).intValue());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setValue(Level.valueOf(Integer.parseInt(text)));
    }
}
