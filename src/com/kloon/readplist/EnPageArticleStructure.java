package com.kloon.readplist;

public class EnPageArticleStructure
{
    public enum PageTypes
    {
        PageType_Cover(1), PageType_Content(2), PageType_Article(3), PageType_Advertisement(4);

        private int code;

        private PageTypes(int c)
        {
            code = c;
        }

        public int PageType()
        {
            return code;
        }
    }
    
    private int pageNumber;
    private PageTypes pageType;
    private int pageTypeInt;
    private String pageTitle;
    private String sectionHeader;
    private int indexWithinPageGroup;
    private boolean pageGroupStart;
    private int articleIndexOnPage;
    
    public EnPageArticleStructure()
    {
        
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
     * @return the pageType
     */
    public PageTypes getPageType()
    {
        return pageType;
    }
    /**
     * @param pageType the pageType to set
     */
    public void setPageType(PageTypes pageType)
    {
        this.pageType = pageType;
    }
    
    /**
     * @return the pageTypeInt
     */
    public int getPageTypeInt()
    {
        return pageTypeInt;
    }
    
    /**
     * @param pageTypeInt the pageTypeInt to set
     */
    public void setPageTypeInt(int pageTypeInt)
    {
        this.pageTypeInt = pageTypeInt;
    }

    /**
     * @return the pageTitle
     */
    public String getPageTitle()
    {
        return pageTitle;
    }
    /**
     * @param pageTitle the pageTitle to set
     */
    public void setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
    }
    /**
     * @return the sectionHeader
     */
    public String getSectionHeader()
    {
        return sectionHeader;
    }
    /**
     * @param sectionHeader the sectionHeader to set
     */
    public void setSectionHeader(String sectionHeader)
    {
        this.sectionHeader = sectionHeader;
    }
    /**
     * @return the indexWithinPageGroup
     */
    public int getIndexWithinPageGroup()
    {
        return indexWithinPageGroup;
    }
    /**
     * @param indexWithinPageGroup the indexWithinPageGroup to set
     */
    public void setIndexWithinPageGroup(int indexWithinPageGroup)
    {
        this.indexWithinPageGroup = indexWithinPageGroup;
    }
    /**
     * @return the pageGroupStart
     */
    public boolean isPageGroupStart()
    {
        return pageGroupStart;
    }
    /**
     * @param pageGroupStart the pageGroupStart to set
     */
    public void setPageGroupStart(boolean pageGroupStart)
    {
        this.pageGroupStart = pageGroupStart;
    }
    /**
     * @return the articleIndexOnPage
     */
    public int getArticleIndexOnPage()
    {
        return articleIndexOnPage;
    }
    /**
     * @param articleIndexOnPage the articleIndexOnPage to set
     */
    public void setArticleIndexOnPage(int articleIndexOnPage)
    {
        this.articleIndexOnPage = articleIndexOnPage;
    }
    
}
