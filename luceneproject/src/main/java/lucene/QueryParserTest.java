package lucene;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;
import com.sun.corba.se.impl.activation.ServerMain;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

public class QueryParserTest {

    public void queryParserTest() throws Exception {
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
        // 创建一个QueryParser对象, 两个参数
        QueryParser queryParser = new QueryParser("content", new MMSegAnalyzer());
        // 使用QueryPaser对象创建一个Query对象
        Query query = queryParser.parse("我是中国人");
        // 执行查询
        printResult(indexSearcher, query);





    }

    // 执行查询的结果
    public void printResult(IndexSearcher indexSearcher, Query query) throws Exception {
        // 第五步：执行查询。
        TopDocs topDocs = indexSearcher.search(query, 10);
        // 第六步：返回查询结果。遍历查询结果并输出。
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            // 文件名称
            String fileName = document.get("name");
            System.out.println(fileName);
            // 文件内容
            String fileContent = document.get("path");
            System.out.println(fileContent);
            // 文件大小
            String fileSize = document.get("size");
            System.out.println(fileSize);
            // 文件路径
            String filePath = document.get("content");
            System.out.println(filePath);
            System.out.println("------------");
        }
    }

    public static void main(String[] args) {

        QueryParserTest query = new QueryParserTest();
        try {
            query.queryParserTest();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
