package xmlhelper;
import java.io.File;  
import java.io.FileOutputStream;  

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jxl.Cell;  
import jxl.Sheet;  
import jxl.Workbook;  


//import org.jdom2.Document;  
//import org.jdom2.Element;  
//import org.jdom2.output.XMLOutputter;  
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
public class Excel2xml 
{
	public void ret(String selectpath,String explorepath,JFrame jframe) 
	{  
		  
        jxl.Workbook readwb = null;  
        String name=null;
        String cumname=null;
        String rowcon=null;
        int iid=0;
        try  
  
        {  
            // 构建Workbook对象, 只读Workbook对象  
  
            // 直接从本地文件创建Workbook,将test.xls放在工程根目录下  
  
            readwb = Workbook.getWorkbook(new File(selectpath));  
           
              
            //循环输出每个sheet到一个xml中  
            int sheetnum = readwb.getNumberOfSheets();
            for (int m = 0; m < sheetnum; m++) 
            {  
            	 // 创建根节点  
            	  
                Element root = new Element("root");  
                // 根节点添加到文档中；  
                Document doc = new Document(root);  
                Sheet readsheet = readwb.getSheet(m);  
  
                // 获取Sheet表中所包含的总列数  
  
                int rsColumns = readsheet.getColumns();  
                
                // 获取Sheet表中所包含的总行数  
  
                int rsRows = readsheet.getRows();  
  
                // 创建sheet根节点  
                //Element root = new Element("root");  
  
                //对每行分别解析  
                for (int i = 3; i < rsRows; i++)
  
                {  
                	if(readsheet.getCell(0, i).getContents() == "")
                		break;
                	name=readsheet.getName();
                    // 创建节点 div;  
                    Element elements = new Element("data");  
                    //解析每列  
                    for (int j = 0; j < rsColumns; j++)
                    {  
                    	iid++;
                        //取出每个单元格  
                        Cell cell = readsheet.getCell(j, i);
                        /*
                        if (cell.getContents() == "") {  
                            continue;  
                        }
                        */
                        elements.addContent("\n");  
                        elements.addContent("\t");  
                        elements.addContent("\t");  
                        elements.addContent("\t");  
                        Element element = new Element(readsheet.getCell(j,1).getContents());
                        cumname=readsheet.getCell(j,1).getContents();
                        rowcon=j+" "+i;
                        //设置节点的属性，同时处理回车换行  
                        if (cell.getContents().contains("\r\n")) {  
                            element.setAttribute("Value", " ");  
                        } else {  
                            element.setAttribute("Value", cell.getContents());  
                        }  
                        elements.addContent(element);  
                    }  
                    elements.addContent("\n");  
                    elements.addContent("\t");  
                    elements.addContent("\t");  
                    root.addContent("\n");  
                    root.addContent("\t");  
                    root.addContent("\t");  
                    root.addContent(elements);  
  
                }  
                root.addContent("\n");
                root.addContent("\t");
                
                XMLOutputter XMLOut = new XMLOutputter();  
                
                // 输出data.xml 文件；  
                XMLOut.output(doc, new FileOutputStream(explorepath+"\\"+readsheet.getName()+".xml"));
            }
            JOptionPane.showMessageDialog(jframe,"导出成功");
            /*
            roots.addContent("\n");  
            XMLOutputter XMLOut = new XMLOutputter();  
  
            // 输出data.xml 文件；  
            XMLOut.output(doc, new FileOutputStream("d://data.xml"));  */
  
        } catch (Exception e) {  
  
        	System.out.println(name+":"+iid);
        	System.out.println(cumname+":"+rowcon);
        	JOptionPane.showMessageDialog(jframe,"导出失败");
            e.printStackTrace();  
            
  
        } finally {  
  
            readwb.close();  
  
        }  
    }  
}
