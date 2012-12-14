package com.kloon.readplist;

public class EnTapArea
{
    private int pageNumber;
    private int indexOnPage;
    private double x;
    private double y;
    private double width;
    private double height;
    
    private int targetType;
    private String targetURL;
    private int integerTag;
    
    private boolean optionSocialSharingTwitter; 
    private boolean optionSocialSharingFacebook;
    private boolean optionSocialSharingEmail;
    private boolean optionSocialSharingOthers;
    private boolean optionSocialSharingIncludeDefaultText;
    
    private boolean optionSocialSharingShareLink;
    private String optionsSocialSharingURL;
    private String optionsSocialSharingTitleOrText;
    
    public EnTapArea()
    {
        pageNumber = -1;
        indexOnPage = -1;
        
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        
        targetType = -1;
        targetURL = "";
        integerTag = -1;
        
        optionSocialSharingTwitter = false;
        optionSocialSharingFacebook = false;
        optionSocialSharingEmail = false;
        optionSocialSharingIncludeDefaultText = false;
        
        optionSocialSharingShareLink = false;
        optionsSocialSharingURL = "";
        optionsSocialSharingTitleOrText = "";
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
      //TODO: use StringBuffer
        String strDes = "(pageNumber: " + pageNumber + ", origin.x: " + x + ", origin.y: " + y + ", size.width: " + width + ", size.height: " + height + ")\n"
                        + "targetType " + targetType + ", optionSocialSharingTwitter " + optionSocialSharingTwitter + ", optionSocialSharingFacebook " + optionSocialSharingFacebook + "\n"
                        + "optionSocialSharingEmail " + optionSocialSharingEmail + ", optionSocialSharingIncludeDefaultText " + optionSocialSharingIncludeDefaultText 
                        + "optionSocialSharingShareLink " + optionSocialSharingShareLink + "\n"
                        + "optionsSocialSharingURL " + optionsSocialSharingURL + ", optionsSocialSharingTitleOrText " + optionsSocialSharingTitleOrText +")";
        return strDes;
    }



    /**
     * @return the pageNumber
     */
    public int getPageNumber()
    {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the indexOnPage
     */
    public int getIndexOnPage()
    {
        return indexOnPage;
    }

    /**
     * @param indexOnPage the indexOnPage to set
     */
    public void setIndexOnPage(int indexOnPage)
    {
        this.indexOnPage = indexOnPage;
    }

    /**
     * @return the targetType
     */
    public int getTargetType()
    {
        return targetType;
    }

    /**
     * @param targetType the targetType to set
     */
    public void setTargetType(int targetType)
    {
        this.targetType = targetType;
    }

    /**
     * @return the targetURL
     */
    public String getTargetURL()
    {
        return targetURL;
    }

    /**
     * @param targetURL the targetURL to set
     */
    public void setTargetURL(String targetURL)
    {
        this.targetURL = targetURL;
    }
    
    /**
     * @return the integerTag
     */
    public int getIntegerTag()
    {
        return integerTag;
    }

    /**
     * @param integerTag the integerTag to set
     */
    public void setIntegerTag(int integerTag)
    {
        this.integerTag = integerTag;
    }

    /**
     * @return the optionSocialSharingTwitter
     */
    public boolean isOptionSocialSharingTwitter()
    {
        return optionSocialSharingTwitter;
    }

    /**
     * @param optionSocialSharingTwitter the optionSocialSharingTwitter to set
     */
    public void setOptionSocialSharingTwitter(boolean optionSocialSharingTwitter)
    {
        this.optionSocialSharingTwitter = optionSocialSharingTwitter;
    }

    /**
     * @return the optionSocialSharingFacebook
     */
    public boolean isOptionSocialSharingFacebook()
    {
        return optionSocialSharingFacebook;
    }

    /**
     * @param optionSocialSharingFacebook the optionSocialSharingFacebook to set
     */
    public void setOptionSocialSharingFacebook(boolean optionSocialSharingFacebook)
    {
        this.optionSocialSharingFacebook = optionSocialSharingFacebook;
    }

    /**
     * @return the optionSocialSharingEmail
     */
    public boolean isOptionSocialSharingEmail()
    {
        return optionSocialSharingEmail;
    }

    /**
     * @param optionSocialSharingEmail the optionSocialSharingEmail to set
     */
    public void setOptionSocialSharingEmail(boolean optionSocialSharingEmail)
    {
        this.optionSocialSharingEmail = optionSocialSharingEmail;
    }
    
    /**
     * @return the optionSocialSharingOthers
     */
    public boolean isOptionSocialSharingOthers()
    {
        return optionSocialSharingOthers;
    }

    /**
     * @param optionSocialSharingOthers the optionSocialSharingOthers to set
     */
    public void setOptionSocialSharingOthers(boolean optionSocialSharingOthers)
    {
        this.optionSocialSharingOthers = optionSocialSharingOthers;
    }

    /**
     * @return the optionSocialSharingIncludeDefaultText
     */
    public boolean isOptionSocialSharingIncludeDefaultText()
    {
        return optionSocialSharingIncludeDefaultText;
    }

    /**
     * @param optionSocialSharingIncludeDefaultText the optionSocialSharingIncludeDefaultText to set
     */
    public void setOptionSocialSharingIncludeDefaultText(
        boolean optionSocialSharingIncludeDefaultText)
    {
        this.optionSocialSharingIncludeDefaultText = optionSocialSharingIncludeDefaultText;
    }

    /**
     * @return the optionSocialSharingShareLink
     */
    public boolean isOptionSocialSharingShareLink()
    {
        return optionSocialSharingShareLink;
    }

    /**
     * @param optionSocialSharingShareLink the optionSocialSharingShareLink to set
     */
    public void setOptionSocialSharingShareLink(boolean optionSocialSharingShareLink)
    {
        this.optionSocialSharingShareLink = optionSocialSharingShareLink;
    }

    /**
     * @return the optionsSocialSharingURL
     */
    public String getOptionsSocialSharingURL()
    {
        return optionsSocialSharingURL;
    }

    /**
     * @param optionsSocialSharingURL the optionsSocialSharingURL to set
     */
    public void setOptionsSocialSharingURL(String optionsSocialSharingURL)
    {
        this.optionsSocialSharingURL = optionsSocialSharingURL;
    }

    /**
     * @return the optionsSocialSharingTitleOrText
     */
    public String getOptionsSocialSharingTitleOrText()
    {
        return optionsSocialSharingTitleOrText;
    }

    /**
     * @param optionsSocialSharingTitleOrText the optionsSocialSharingTitleOrText to set
     */
    public void setOptionsSocialSharingTitleOrText(
        String optionsSocialSharingTitleOrText)
    {
        this.optionsSocialSharingTitleOrText = optionsSocialSharingTitleOrText;
    }

    /**
     * @return the x
     */
    public double getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * @return the width
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height)
    {
        this.height = height;
    }
    
    
}
