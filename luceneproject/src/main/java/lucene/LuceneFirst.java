package lucene;

import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;
import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;


import java.io.File;

/**
 * 创建索引
 * @author chenhua
 */
public class LuceneFirst {

    /**
     * 创建索引
     * @throws Exception
     */
    public void createIndex() throws Exception {
        /**
         * 1. 创建一个Director对象, 指定索引保存的位置
         */
        // 把索引保存在内存中
        // RAMDirectory ramDirectory Z= new RAMDirectory();
        // 把索引保存在磁盘上
        FSDirectory fsDirectory = FSDirectory.open(new File("/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/index").toPath());
        /**
         * 2. 基于Directory对象创建一个IndexWriter对象
         */
        IndexWriterConfig config = new IndexWriterConfig(new MMSegAnalyzer());
        IndexWriter indexWriter = new IndexWriter(fsDirectory, config);

        /**
         * 3. 读取磁盘上的文件, 对应每个文件创建一个文档对象
         */
        File file = new File("/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/myfile");
        File[] files = file.listFiles();
        for (File f : files) {
            // 文件名
            String fileName = f.getName();
            // 文件路径
            String filePath = f.getPath();
            // 文件内容
            String fileContent = FileUtils.readFileToString(f, "utf-8");
            System.out.println(fileContent);
            System.out.println("==============");
            // 文件大小
            long fileSize = FileUtils.sizeOf(f);
            /**
             * 创建Filed(域名)
             */

            // 参数1: 域的名称  参数2: 域的内容, 参数3: 是否存储
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
//            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            StoredField fieldPath = new StoredField("path", filePath);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
//            Field fieldSize = new TextField("size", fileSize + "", Field.Store.YES);
            LongPoint fieldSizeValue = new LongPoint("size", fileSize);
            StoredField filedSizeStore = new StoredField("size", fileSize);

            /**
             * 创建文档对象
             */
            Document document = new Document();
            /**
             * 向文档对象添加域
             */
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
//            document.add(fieldSize);
            document.add(fieldSizeValue);
            document.add(filedSizeStore);
            /**
             * 把文档对象写入索引库
             */
            indexWriter.addDocument(document);


        }
        /**
         * 关闭indexWriter对象
         */
        indexWriter.close();
    }


    /**
     * 英文分析器
     * @throws Exception
     */
    public void testTokenStream() throws Exception {
        /**
         * 创建一个
         * Analyzer对象, StandardAnalyzer对象
         */
        StandardAnalyzer analyzer = new StandardAnalyzer();
        /**
         * 使用分析器对象的tokenStream方法获得一个TokenStream对象
         */
//        TokenStream tokenStream = analyzer.tokenStream("", "The Spring Framework provides a comprehensive programming and configuration model.");
        TokenStream tokenStream = analyzer.tokenStream("", "Hi! I am ChenHua");
        /**
         * 向tokenStream对象设置一个引用, 相当于一个指针
         */
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        /**
         * 调用TokenStream对象的rest方法, 如果不调用抛异常
         */
        tokenStream.reset();
        /**
         * 使用while循环遍历TokenStream对象
         */
        while (tokenStream.incrementToken()) {
            System.out.println(charTermAttribute.toString());
        }

        /**
         * 关闭TokenStream对象
         */
        tokenStream.close();

    }

    /**
     * 中文分词分析器
     * @throws Exception
     */
    public void chinaTokenStreamTest() throws Exception {
        /**
         * 创建一个
         * Analyzer对象, StandardAnalyzer对象
         */
//        SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer();
//        ComplexAnalyzer complexAnalyzer = new ComplexAnalyzer();
        MMSegAnalyzer mmSegAnalyzer = new MMSegAnalyzer();
//        ComplexAnalyzer mmSegAnalyzer = new ComplexAnalyzer();
        /**
         * 使用分析器对象的tokenStream方法获得一个TokenStream对象
         */
        String text = "宝贝, 么么哒! 我操你妈, 外国人";
//        TokenStream tokenStream = smartChineseAnalyzer.tokenStream("", text);
//        TokenStream tokenStream = complexAnalyzer.tokenStream("", text);
        TokenStream tokenStream = mmSegAnalyzer.tokenStream("", text);
        /**
         * 向tokenStream对象设置一个引用, 相当于一个指针
         */
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        /**
         * 调用TokenStream对象的rest方法, 如果不调用抛异常
         */
        tokenStream.reset();
        /**
         * 使用while循环遍历TokenStream对象
         */
        while (tokenStream.incrementToken()) {
            System.out.println(charTermAttribute.toString());
        }

        /**
         * 关闭TokenStream对象
         */
        tokenStream.close();
    }

    public static void main(String[] args) throws Exception {
        LuceneFirst luceneFirst = new LuceneFirst();
        luceneFirst.chinaTokenStreamTest();
    }

}
