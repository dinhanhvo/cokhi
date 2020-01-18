package com.smartevn.cokhi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StyleSheet")
public class StyleSheetModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="`class`")
    private String class_name;
    private String description;
    private String bgimage;
    private String image;
    private int width;
    private int height;
    private String font_color;
    private int font_size;
    private String font_weight;
    private String icon;
    private String bgcolor;
    private String text_align;
    private int padding_left;
    private int padding_right;
    private int padding_top;
    private int padding_down;
    private int margin_top;
    private int margin_right;
    private int margin_down;
    private int margin_left;
    private String justify_content;
    private String border;
    private int itemId;
    private int lineHeight;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getClass_name() {
        return class_name;
    }
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBgimage() {
        return bgimage;
    }
    public void setBgimage(String bgimage) {
        this.bgimage = bgimage;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getFont_color() {
        return font_color;
    }
    public void setFont_color(String font_color) {
        this.font_color = font_color;
    }
    public int getFont_size() {
        return font_size;
    }
    public void setFont_size(int font_size) {
        this.font_size = font_size;
    }
    public String getFont_weight() {
        return font_weight;
    }
    public void setFont_weight(String font_weight) {
        this.font_weight = font_weight;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getBgcolor() {
        return bgcolor;
    }
    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }
    public String getText_align() {
        return text_align;
    }
    public void setText_align(String text_align) {
        this.text_align = text_align;
    }
    public int getPadding_left() {
        return padding_left;
    }
    public void setPadding_left(int padding_left) {
        this.padding_left = padding_left;
    }
    public int getPadding_right() {
        return padding_right;
    }
    public void setPadding_right(int padding_right) {
        this.padding_right = padding_right;
    }
    public int getPadding_top() {
        return padding_top;
    }
    public void setPadding_top(int padding_top) {
        this.padding_top = padding_top;
    }
    public int getPadding_down() {
        return padding_down;
    }
    public void setPadding_down(int padding_down) {
        this.padding_down = padding_down;
    }
    public int getMargin_top() {
        return margin_top;
    }
    public void setMargin_top(int margin_top) {
        this.margin_top = margin_top;
    }
    public int getMargin_right() {
        return margin_right;
    }
    public void setMargin_right(int margin_right) {
        this.margin_right = margin_right;
    }
    public int getMargin_down() {
        return margin_down;
    }
    public void setMargin_down(int margin_down) {
        this.margin_down = margin_down;
    }
    public int getMargin_left() {
        return margin_left;
    }
    public void setMargin_left(int margin_left) {
        this.margin_left = margin_left;
    }
    public String getJustify_content() {
        return justify_content;
    }
    public void setJustify_content(String justify_content) {
        this.justify_content = justify_content;
    }
    public String getBorder() {
        return border;
    }
    public void setBorder(String border) {
        this.border = border;
    }
    public int getItem_id() {
        return itemId;
    }
    public void setItem_id(int item_id) {
        this.itemId = item_id;
    }

}
