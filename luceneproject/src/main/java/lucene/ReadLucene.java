package lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * 查询数据
 * @author chenhua
 */
public class ReadLucene {

    public void MyRead() throws Exception {
        /**
         * 创建一个Directory对象, 指定索引库的位置
         */
        FSDirectory fsDirectory = FSDirectory.open(new File("/media/chenhua/DATA/IdeaProject/luceneproject/src/main/resources/index").toPath());
        /**
         * 创建一个IndexReader对象
         */
        DirectoryReader directoryReader = DirectoryReader.open(fsDirectory);
        /**
         * 创建一个IndexSearcher对象, 构造方法中的参数indexReader对象
         */
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

        /**
         * 创建一个Query对象, TermQuery
         */
        Query query = new TermQuery(new Term("content", "我是中国人"));
        /**
         * 执行查询, 得到一个TopDocs对象
         */
        TopDocs topDocs = indexSearcher.search(query, 10);
        /**
         * 取查询结果的总记录数
         */
        System.out.println("总记录数:"+topDocs.totalHits);
        /**
         * 取文档列表
         */
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        /**
         * 打印文档中的内容
         */
        for (ScoreDoc doc : scoreDocs) {
            // 取文档id
            int docId = doc.doc;
            // 根据id取文档对象
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
            System.out.println(document.get("content"));
            System.out.println("-------------------------------");

        }
        /**
         * 关闭IndexReader对象
         */
        directoryReader.close();


    }


    public static void main(String[] args) {
        ReadLucene readLucene = new ReadLucene();
        try {
            readLucene.MyRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
