package lucene;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * 添加文档
 * @author chenhua
 */
public class IndexManager {

    private final static String INDEX_PATH = "/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/index";
    private final static String FILE_PATH = "/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/myfile";



    /**
     * 添加文档
     * @param fileName 文件名
     * @param content 文件内容
     * @throws Exception
     */
    public void addDocument(String fileName, String content) throws Exception {
        // 索引库路径
        File file = new File(INDEX_PATH);
        // 创建Directory对象, 指定索引库
        FSDirectory fsDirectory = FSDirectory.open(file.toPath());
        // 指定使用的中文分词
        IndexWriterConfig config = new IndexWriterConfig(new MMSegAnalyzer());
        // 创建IndexWriter, 用于创建索引
        IndexWriter indexWriter = new IndexWriter(fsDirectory, config);
        // 创建Document对象
        Document document = new Document();
        // 向Document对象添加域
        document.add(new TextField("name", fileName, Field.Store.YES));
        document.add(new TextField("content", content, Field.Store.YES));
        document.add(new TextField("path", FILE_PATH, Field.Store.YES));
        // 向索引库中添加文档
        indexWriter.addDocument(document);
        // 关闭索引库
        indexWriter.close();

    }


    /**
     * 删除所有文档
     * @throws Exception
     */
    public void deleteAllDocument() throws Exception {
        // 索引库路径
        File file = new File(INDEX_PATH);
        // 创建Directory对象, 指定索引库
        FSDirectory fsDirectory = FSDirectory.open(file.toPath());
        // 指定使用的中文分词
        IndexWriterConfig config = new IndexWriterConfig(new MMSegAnalyzer());
        // 创建IndexWriter, 用于创建索引
        IndexWriter indexWriter = new IndexWriter(fsDirectory, config);
        // 删除所有索引库
        indexWriter.deleteAll();
        // 关闭索引库
        indexWriter.close();
    }


    /**
     * 选择性删除
     * @throws Exception
     */
    public void deleteDocumentByQuery() throws Exception {
        // 索引库路径
        File file = new File(INDEX_PATH);
        // 创建Directory对象, 指定索引库
        FSDirectory fsDirectory = FSDirectory.open(file.toPath());
        // 指定使用的中文分词
        IndexWriterConfig config = new IndexWriterConfig(new MMSegAnalyzer());
        // 创建IndexWriter, 用于创建索引
        IndexWriter indexWriter = new IndexWriter(fsDirectory, config);
        // 根据id删除索引库
        indexWriter.deleteDocuments(new Term("name", "apache"));
        // 关闭索引库
        indexWriter.close();
    }



    /**
     * 更新索引库存
     * 原理: 先删除, 后添加
     * @throws Exception
     */
    public void updateDocument() throws Exception {
        // 索引库路径
        File file = new File(INDEX_PATH);
        // 创建Directory对象, 指定索引库
        FSDirectory fsDirectory = FSDirectory.open(file.toPath());
        // 指定使用的中文分词
        IndexWriterConfig config = new IndexWriterConfig(new MMSegAnalyzer());
        // 创建IndexWriter, 用于创建索引
        IndexWriter indexWriter = new IndexWriter(fsDirectory, config);
        // 创建文档对象
        Document document = new Document();
        // 向文档中添加域
        document.add(new TextField("name", "更新后的文档", Field.Store.YES));
        document.add(new TextField("name2", "更新后的文档2", Field.Store.YES));
        document.add(new TextField("name3", "更新后的文档3", Field.Store.YES));
        // 更新操作
        indexWriter.updateDocument(new Term("name", "apache"), document);
        // 关闭索引库存
        indexWriter.close();
    }







    public static void main(String[] args) throws Exception {
        IndexManager indexManager = new IndexManager();
//        indexManager.updateDocument();
//        indexManager.deleteDocumentByQuery();
        indexManager.deleteAllDocument();
//        String indexPath = "/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/index";
//        String filePath = "/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/myfile";
//        String fileName = "郑泽文标题";
//        String content = "我怕郑泽文不是个傻子吧";
//        try {
//            indexManager.addDocument(fileName, content);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
