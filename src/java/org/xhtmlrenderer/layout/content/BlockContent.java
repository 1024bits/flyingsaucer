/*
 * BlockContent.java
 * Copyright (c) 2004, 2005 Torbj�rn Gannholm
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 */
package org.xhtmlrenderer.layout.content;

import org.w3c.dom.Element;
import org.xhtmlrenderer.css.newmatch.CascadedStyle;
import org.xhtmlrenderer.layout.Context;

import java.util.List;


/**
 * Represents the content of a "block"-display element
 *
 * @author Torbj�rn Gannholm
 */
public class BlockContent extends AbstractCollapsableContent implements CollapsableContent {
    /**
     * Description of the Field
     */
    private Element _elem;
    /**
     * Description of the Field
     */
    private CascadedStyle _style;
    
    //TODO: make constructor package local
    /**
     * Constructor for the BlockContent object
     *
     * @param e     PARAM
     * @param style PARAM
     */
    public BlockContent(Element e, CascadedStyle style) {
        _elem = e;
        _style = style;
    }

    /**
     * Converts to a String representation of the object.
     *
     * @return A string representation of the object.
     */
    public String toString() {
        return "Block: " + _elem.getNodeName();
    }

    /**
     * Gets the element attribute of the BlockContent object
     *
     * @return The element value
     */
    public Element getElement() {
        return _elem;
    }

    /**
     * Gets the style attribute of the BlockContent object
     *
     * @return The style value
     */
    public CascadedStyle getStyle() {
        return _style;
    }

    protected List makeChildContent(Context c) {
        return ContentUtil.getChildContentList(c, this);
    }

    public boolean mayCollapseInto() {
        // not the whole story since overflow property must be checked too
        return true;
    }
}

