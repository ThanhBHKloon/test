package com.kloon.readplist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import com.dd.plist.UID;

public class MainActivity extends Activity
{
    ArrayList <EnTapArea> tapAreaList;
    ArrayList <EnPageArticleStructure> pageArticleStructureList;
    
    private static String NULL = "$null";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageArticleStructureList = new ArrayList<EnPageArticleStructure>();
        // File file = new
        // File(Environment.getExternalStorageDirectory().getPath() + "/ToanNV/"
        // + "plist1.plist");
        // File file = new
        // File("file:///android_asset/tapareas_pit_woodandform01.plist");

//        File fpdf = new File(getCacheDir() + "/issue_franzisolympus_460064.pdf");
//        
//        try
//        {
//
//            InputStream is = getAssets().open(
//                "issue_franzisolympus_460064.pdf");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//
//            FileOutputStream fos = new FileOutputStream(fpdf);
//            fos.write(buffer);
//            fos.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
        File f = new File(getCacheDir() + "/docstruct_pit_woodandform01.plist");
//        if (!f.exists())
            try
            {

                InputStream is = getAssets().open(
                    "docstruct_pit_woodandform01.plist");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();

                FileOutputStream fos = new FileOutputStream(f);
                fos.write(buffer);
                fos.close();
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
//        File f2 = new File(getCacheDir() + "/tapareas_pit_woodandform01_a.plist");
            try
            {
                Log.d("Toan", "path:" + f.getPath());
                InputStream is = getAssets().open(
                        "docstruct_pit_woodandform01.plist");//
//                InputStream is = getAssets().open(
//                        "docstruct_pit_aa673280-04d9-0130-72dd-123138094690.plist");
                NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(is);
                String[] staa = rootDict.allKeys();
                Log.d("Toan", "rootDict:" + staa.length);
                for(String s : staa)
                {
                    Log.d("Toan", "rootDict:" + s);
                }
                
                NSArray nsa = (NSArray) rootDict.objectForKey("$objects");
////                Log.d("Toan", "nsArray:" + nsa.count());
                
//                for(int i = 0; i < nsa.count(); i ++)
//                {
////                    Log.d("Toan", "nsArray:" + i + " " + nsa.objectAtIndex(i));
//                    
//                    if(i==3)
//                    {
//                        
//                    }
//                    
//                }
                
                Log.d("Toan", "nsArray:" + 3 + " " + nsa.objectAtIndex(3));
                try
                {
                    NSDictionary nsd1 = (NSDictionary) nsa.objectAtIndex(3);
//                    for(String s : staa1)
//                    {
//                        Log.d("Toan", "staa1 KEY:" + count + " " + s);
//                    }
                    
                    NSArray nsa1 = (NSArray) nsd1.objectForKey("NS.objects");
                    Log.d("Toan", "nsa1:" + nsa1);
                    for(int k = 0; k < nsa1.count(); k ++)
                    {
                        Log.d("Toan", "nsa1.objectAtIndex(k):" + k + " " + nsa1.objectAtIndex(k));
                        try
                        {
                            UID uidObject = (UID) nsa1.objectAtIndex(k);
//                            for(String s : staa1)
//                            {
//                                Log.d("Toan", "staa1 KEY:" + count + " " + s);
//                            }
//                            String strUID = uid.toXMLPropertyList();
//                            String pos = strUID.substring( 172, strUID.length() - 18);
//                            Log.d("Toan", "CF$UID:" + k + " " + Integer.parseInt(pos,16));
//                            Log.d("Toan", "nsArray:" + Integer.parseInt(pos,16) + " " + nsa.objectAtIndex(Integer.parseInt(pos,16)));
//                            
//                            int index = Integer.parseInt(pos,16);
                            int index = getUID(uidObject);
                            EnPageArticleStructure pageArticleStructure = new EnPageArticleStructure();
                            NSDictionary nsdpageArticleStructure = (NSDictionary) nsa.objectAtIndex(index);
                            pageArticleStructure.setPageNumber(Integer.parseInt(nsdpageArticleStructure.objectForKey("pageNumber").toString()));
                            Log.d("Toan", "pageNumber:" + pageArticleStructure.getPageNumber());
                            
                            Log.d("Toan", "pageType:" + nsdpageArticleStructure.objectForKey("pageType").toString());
                            pageArticleStructure.setPageTypeInt(Integer.parseInt(nsdpageArticleStructure.objectForKey("pageType").toString()));
                            Log.d("Toan", "getPageTypeInt:" + pageArticleStructure.getPageTypeInt());
                            
                            UID pageTitle = (UID) nsdpageArticleStructure.objectForKey("pageTitle");
                            int pageTitleUID = getUID(pageTitle);
                            
                            try
                            {
                                NSDictionary pageTitleSub = (NSDictionary) nsa.objectAtIndex(pageTitleUID);
                                Log.d("Toan", "pageTitleSub:" + pageTitleSub.toXMLPropertyList());
                                String strPageTitle = pageTitleSub.objectForKey("NS.string").toString();
                                Log.d("Toan", "strPageTitle:" + pageTitleUID + " " + strPageTitle);
                                pageArticleStructure.setPageTitle(strPageTitle);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                                
                                Log.d("Toan", "nsa:" + nsa.objectAtIndex(pageTitleUID).toXMLPropertyList());
                                String strPageTitle = nsa.objectAtIndex(pageTitleUID).toString();
                                Log.d("Toan", "strPageTitle:" + pageTitleUID + " " + strPageTitle);
                                pageArticleStructure.setPageTitle(strPageTitle);
                            }
                            
                            UID sectionHeader = (UID) nsdpageArticleStructure.objectForKey("sectionHeader");
                            int sectionHeaderUID = getUID(sectionHeader);
                            try
                            {
                                NSDictionary sectionHeaderSub = (NSDictionary) nsa.objectAtIndex(sectionHeaderUID);
                                Log.d("Toan", "sectionHeaderUID:" + sectionHeaderSub.toXMLPropertyList());
                                String strSectionHeader = sectionHeaderSub.objectForKey("NS.string").toString();
                                Log.d("Toan", "strSectionHeader:" + sectionHeaderUID + " " + strSectionHeader);
                                pageArticleStructure.setSectionHeader(strSectionHeader);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                                
                                String strSectionHeader = nsa.objectAtIndex(sectionHeaderUID).toString();
                                Log.d("Toan", "strSectionHeader:" + sectionHeaderUID + " " + strSectionHeader);
                                pageArticleStructure.setSectionHeader(strSectionHeader);
                            }
                            
                            
                            pageArticleStructure.setIndexWithinPageGroup(Integer.parseInt(nsdpageArticleStructure.objectForKey("indexWithinPageGroup").toString()));
                            Log.d("Toan", "setIndexWithinPageGroup:" + pageArticleStructure.getIndexWithinPageGroup());
                            
                            Log.d("Toan", "pageGroupStart:" + nsdpageArticleStructure.objectForKey("pageGroupStart").toXMLPropertyList());
                            pageArticleStructure.setPageGroupStart(nsdpageArticleStructure.objectForKey("pageGroupStart").toXMLPropertyList().contains("<true/>"));
                            Log.d("Toan", "pageArticleStructure.getPageGroupStart:" + pageArticleStructure.isPageGroupStart());
                            
                            pageArticleStructure.setArticleIndexOnPage(Integer.parseInt(nsdpageArticleStructure.objectForKey("articleIndexOnPage").toString()));
                            Log.d("Toan", "setIndexWithinPageGroup.setArticleIndexOnPage:" + pageArticleStructure.getArticleIndexOnPage());
                            
                            Log.d("Toan", pageArticleStructure.toString());
                            
                            
                            if(!(NULL.equalsIgnoreCase(pageArticleStructure.getPageTitle()) && NULL.equalsIgnoreCase(pageArticleStructure.getSectionHeader())))
                            {
                                pageArticleStructureList.add(pageArticleStructure);
                            }
                            Log.d("Toan", "+++++++++++++++++++++++");
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("Toan", "++++++pageArticleStructureList++++++++++++++++" + pageArticleStructureList.size());
                for(EnPageArticleStructure pageArticleStructure: pageArticleStructureList)
                {
                    Log.d("Toan", pageArticleStructure.getPageTitle() + pageArticleStructure.getSectionHeader());
                }
////                rootDict.objectForKey("$objects").toXMLPropertyList();
//                FileOutputStream fos = new FileOutputStream(f);
//                FileOutputStream fos2 = new FileOutputStream(f2);
//                fos.write(rootDict.toXMLPropertyList().getBytes("UTF-16"));
//                String s = rootDict.objectForKey("$objects").toXMLPropertyList();
//                s = s.substring(6, s.length() - 7);
                TextView tv = (TextView) findViewById(R.id.text);
                tv.setText(rootDict.toXMLPropertyList().toString());
                
//               tv.setText(rootDict.toXMLPropertyList());
//                fos2.write(s.getBytes("UTF-16"));
////                Log.d("Toan", "objects:" + rootDict.objectForKey("$objects").toXMLPropertyList());
//                fos.close();
//                fos2.close();
//                NSDictionary nsArray = (NSDictionary) rootDict.objectForKey("key");
//                Log.d("Toan", "nsArray:" + nsArray);
            }
            catch (Exception e)
            {
                Log.d("Toan", "ex:" + e);
            }
        
//        try
//        {
//            Map<String, Object> properties = Plist.load(f.getPath());
//            
//            TextView tv = (TextView) findViewById(R.id.text);
////            tv.setText(properties.get("$objects").toString());
//            
//            ArrayList<Object> objectList = (ArrayList) properties.get("$objects");
//            
//            for(Object o : objectList)
//            {
//                Log.d("Toan", "o:" + o);
//            }
//            Log.d("Toan", "objectList:" + objectList.size());
//        }
//        catch (XmlParseException e1)
//        {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        catch (IOException e1)
//        {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
    }
    
    void loadTapArea()
    {
        File f = new File(getCacheDir() + "/tapareas_pit_woodandform01.plist");
//      if (!f.exists())
          try
          {

              InputStream is = getAssets().open(
                  "tapareas_pit_woodandform01.plist");
              int size = is.available();
              byte[] buffer = new byte[size];
              is.read(buffer);
              is.close();

              FileOutputStream fos = new FileOutputStream(f);
              fos.write(buffer);
              fos.close();
          }
          catch (Exception e)
          {
              throw new RuntimeException(e);
          }
//      File f2 = new File(getCacheDir() + "/tapareas_pit_woodandform01_a.plist");
      try
      {
          Log.d("Toan", "path:" + f.getPath());
          InputStream is = getAssets().open(
                  "tapareas_pit_woodandform01.plist");//tapareas_pit_aa673280-04d9-0130-72dd-123138094690.plist
          NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(is);
          String[] staa = rootDict.allKeys();
          Log.d("Toan", "rootDict:" + staa.length);
          for(String s : staa)
          {
              Log.d("Toan", "rootDict:" + s);
          }
          
          NSArray nsa = (NSArray) rootDict.objectForKey("$objects");
////          Log.d("Toan", "nsArray:" + nsa.count());
          
          for(int i = 0; i < nsa.count(); i ++)
          {
//              Log.d("Toan", "nsArray:" + i + " " + nsa.objectAtIndex(i));
              
              if(i==3)
              {
                  Log.d("Toan", "nsArray:" + i + " " + nsa.objectAtIndex(i));
                  try
                  {
                      NSDictionary nsd1 = (NSDictionary) nsa.objectAtIndex(i);
//                      for(String s : staa1)
//                      {
//                          Log.d("Toan", "staa1 KEY:" + count + " " + s);
//                      }
                      
                      NSArray nsa1 = (NSArray) nsd1.objectForKey("NS.objects");
                      Log.d("Toan", "nsa1:" + nsa1);
                      for(int k = 0; k < nsa1.count(); k ++)
                      {
                          Log.d("Toan", "nsa1.objectAtIndex(k):" + k + " " + nsa1.objectAtIndex(k));
                          try
                          {
                              UID uidObject = (UID) nsa1.objectAtIndex(k);
//                              for(String s : staa1)
//                              {
//                                  Log.d("Toan", "staa1 KEY:" + count + " " + s);
//                              }
//                              String strUID = uid.toXMLPropertyList();
//                              String pos = strUID.substring( 172, strUID.length() - 18);
//                              Log.d("Toan", "CF$UID:" + k + " " + Integer.parseInt(pos,16));
//                              Log.d("Toan", "nsArray:" + Integer.parseInt(pos,16) + " " + nsa.objectAtIndex(Integer.parseInt(pos,16)));
//                              
//                              int index = Integer.parseInt(pos,16);
                              int index = getUID(uidObject);
                              EnTapArea tapArea = new EnTapArea();
                              NSDictionary nsdTapArea = (NSDictionary) nsa.objectAtIndex(index);
                              tapArea.setPageNumber(Integer.parseInt(nsdTapArea.objectForKey("pageNumber").toString()));
                              Log.d("Toan", "pageNumber:" + tapArea.getPageNumber());
                              tapArea.setIndexOnPage(Integer.parseInt(nsdTapArea.objectForKey("indexOnPage").toString()));
                              Log.d("Toan", "indexOnPage:" + tapArea.getIndexOnPage());
                              
                              UID frame = (UID) nsdTapArea.objectForKey("frame");
                              int frameUID = getUID(frame);
                              String strFrame = nsa.objectAtIndex(frameUID).toString();
                              Log.d("Toan", "strFrame:" + frameUID + " " + strFrame);
                              String[] strFrameParams = strFrame.replaceAll("\\{", "").replaceAll("\\}", "").split(",");
                              Log.d("Toan", "strFrameParams:" + strFrameParams);
                              tapArea.setX(Double.parseDouble(strFrameParams[0]));
                              Log.d("Toan", "tapArea.getX:" + tapArea.getX());
                              tapArea.setY(Double.parseDouble(strFrameParams[1]));
                              Log.d("Toan", "tapArea.getY:" + tapArea.getY());
                              tapArea.setWidth(Double.parseDouble(strFrameParams[2]));
                              Log.d("Toan", "tapArea.getWidth:" + tapArea.getWidth());
                              tapArea.setHeight(Double.parseDouble(strFrameParams[3]));
                              Log.d("Toan", "tapArea.getHeight:" + tapArea.getHeight());
                              
                              tapArea.setTargetType(Integer.parseInt(nsdTapArea.objectForKey("targetType").toString()));
                              Log.d("Toan", "tapArea.getTargetType:" + tapArea.getTargetType());
                              
                              tapArea.setTargetURL(nsdTapArea.objectForKey("targetURL").toString());
                              Log.d("Toan", "tapArea.getTargetURL:" + tapArea.getTargetURL());
                              
                              tapArea.setIntegerTag(Integer.parseInt(nsdTapArea.objectForKey("integerTag").toString()));
                              Log.d("Toan", "tapArea.getIntegerTag:" + tapArea.getIntegerTag());
                              
                              Log.d("Toan", "optionSocialSharingTwitter:" + nsdTapArea.objectForKey("optionSocialSharingTwitter").toXMLPropertyList());
                              tapArea.setOptionSocialSharingTwitter(nsdTapArea.objectForKey("optionSocialSharingTwitter").toXMLPropertyList().contains("<true/>"));
                              Log.d("Toan", "tapArea.getOptionSocialSharingTwitter:" + tapArea.isOptionSocialSharingTwitter());
                              
                              Log.d("Toan", "optionSocialSharingFacebook:" + nsdTapArea.objectForKey("optionSocialSharingFacebook").toXMLPropertyList());
                              tapArea.setOptionSocialSharingFacebook(nsdTapArea.objectForKey("optionSocialSharingFacebook").toXMLPropertyList().contains("<true/>"));
                              Log.d("Toan", "tapArea.getoptionSocialSharingFacebook:" + tapArea.isOptionSocialSharingFacebook());
                              
                              Log.d("Toan", "optionSocialSharingEmail:" + nsdTapArea.objectForKey("optionSocialSharingEmail").toXMLPropertyList());
                              tapArea.setOptionSocialSharingEmail(nsdTapArea.objectForKey("optionSocialSharingEmail").toXMLPropertyList().contains("<true/>"));
                              Log.d("Toan", "tapArea.getOptionSocialSharingEmail:" + tapArea.isOptionSocialSharingEmail());
                              
                              Log.d("Toan", "optionSocialSharingOthers:" + nsdTapArea.objectForKey("optionSocialSharingOthers").toXMLPropertyList());
                              tapArea.setOptionSocialSharingOthers(nsdTapArea.objectForKey("optionSocialSharingOthers").toXMLPropertyList().contains("<true/>"));
                              Log.d("Toan", "tapArea.optionSocialSharingOthers:" + tapArea.isOptionSocialSharingOthers());
                              
                              Log.d("Toan", "optionSocialSharingIncludeDefaultText:" + nsdTapArea.objectForKey("optionSocialSharingIncludeDefaultText").toXMLPropertyList());
                              tapArea.setOptionSocialSharingIncludeDefaultText(nsdTapArea.objectForKey("optionSocialSharingIncludeDefaultText").toXMLPropertyList().contains("<true/>"));
                              Log.d("Toan", "tapArea.optionSocialSharingIncludeDefaultText:" + tapArea.isOptionSocialSharingIncludeDefaultText());
                              
                              Log.d("Toan", "optionSocialSharingShareLink:" + nsdTapArea.objectForKey("optionSocialSharingShareLink").toXMLPropertyList());
                              tapArea.setOptionSocialSharingShareLink(nsdTapArea.objectForKey("optionSocialSharingShareLink").toXMLPropertyList().contains("<true/>"));
                              Log.d("Toan", "tapArea.optionSocialSharingShareLink:" + tapArea.isOptionSocialSharingShareLink());
                              
                              UID optionsSocialSharingURL = (UID) nsdTapArea.objectForKey("optionsSocialSharingURL");
                              int optionsSocialSharingURLUID = getUID(optionsSocialSharingURL);
                              String strOptionsSocialSharingURL = nsa.objectAtIndex(optionsSocialSharingURLUID).toString();
                              Log.d("Toan", "strOptionsSocialSharingURL:" + optionsSocialSharingURLUID + " " + strOptionsSocialSharingURL);
                              tapArea.setOptionsSocialSharingURL(strOptionsSocialSharingURL);
                              
                              UID optionsSocialSharingTitleOrText = (UID) nsdTapArea.objectForKey("optionsSocialSharingTitleOrText");
                              int optionsSocialSharingTitleOrTextUID = getUID(optionsSocialSharingTitleOrText);
                              String stroptionsSocialSharingTitleOrText = nsa.objectAtIndex(optionsSocialSharingTitleOrTextUID).toString();
                              Log.d("Toan", "stroptionsSocialSharingTitleOrText:" + optionsSocialSharingTitleOrTextUID + " " + stroptionsSocialSharingTitleOrText);
                              tapArea.setOptionsSocialSharingTitleOrText(stroptionsSocialSharingTitleOrText);
                              
                              Log.d("Toan", tapArea.toString());
                              Log.d("Toan", "+++++++++++++++++++++++");
                              
                          }
                          catch (Exception e) {
                              e.printStackTrace();
                          }
                      }
                      
                  }
                  catch (Exception e) {
                      e.printStackTrace();
                  }
              }
              
          }
////          rootDict.objectForKey("$objects").toXMLPropertyList();
//          FileOutputStream fos = new FileOutputStream(f);
//          FileOutputStream fos2 = new FileOutputStream(f2);
//          fos.write(rootDict.toXMLPropertyList().getBytes("UTF-16"));
//          String s = rootDict.objectForKey("$objects").toXMLPropertyList();
//          s = s.substring(6, s.length() - 7);
          TextView tv = (TextView) findViewById(R.id.text);
          tv.setText(rootDict.toXMLPropertyList().toString());
          
//         tv.setText(rootDict.toXMLPropertyList());
//          fos2.write(s.getBytes("UTF-16"));
////          Log.d("Toan", "objects:" + rootDict.objectForKey("$objects").toXMLPropertyList());
//          fos.close();
//          fos2.close();
//          NSDictionary nsArray = (NSDictionary) rootDict.objectForKey("key");
//          Log.d("Toan", "nsArray:" + nsArray);
      }
      catch (Exception e)
      {
          Log.d("Toan", "ex:" + e);
      }
    }
    
    public static int getUID(UID uid)
    {
        String strUID = uid.toXMLPropertyList();
        
        String pos = strUID.substring( 172, strUID.length() - 18);
        Log.d("Toan", "getUID pos " + pos);
        return (Integer.parseInt(pos, 16));
    }
    
    public static int byteArrayToInt(byte[] encodedValue) {
        int index = 0;
        int value = encodedValue[index++] << Byte.SIZE * 3;
        value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 2;
        value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 1;
        value ^= (encodedValue[index++] & 0xFF);
        return value;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
