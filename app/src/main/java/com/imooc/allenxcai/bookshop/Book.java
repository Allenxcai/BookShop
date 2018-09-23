package com.imooc.allenxcai.bookshop;

public class Book {
    private String name;
    private String type;
    private boolean history;
    private boolean art;
    private boolean suspense;
    private int fitAge;
    private int pic;

    public Book() {
    }

    public Book(String name, int pic, boolean history, boolean art, boolean suspense, int fitAge,String type) {
        this.name = name;
        this.history = history;
        this.art = art;
        this.suspense = suspense;
        this.fitAge = fitAge;
        this.pic = pic;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isArt() {
        return art;
    }

    public void setArt(boolean art) {
        this.art = art;
    }

    public boolean isSuspense() {
        return suspense;
    }

    public void setSuspense(boolean suspense) {
        this.suspense = suspense;
    }

    public int getFitAge() {
        return fitAge;
    }

    public void setFitAge(int fitage) {
        this.fitAge = fitAge;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "书名：" + getName() +  "  文艺：" + isArt() + "  历史：" + isHistory() + "  悬疑：" + isSuspense()+"  适合年纪：" + getFitAge()+"岁";
    }
}
