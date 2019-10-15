package com.atguigu;

import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;
import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;
import lucene.LuceneFirst;
import lucene.ReadLucene;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;


public class MyTest {

    @Test
    public void  test1() throws Exception {
        LuceneFirst luceneFirst = new LuceneFirst();
        luceneFirst.createIndex();
    }

    @Test
    public void test2() throws Exception {
        ReadLucene readLucene = new ReadLucene();
        readLucene.MyRead();
    }

    @Test
    public void test3() {
        LuceneFirst luceneFirst = new LuceneFirst();
        try {
            luceneFirst.testTokenStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        LuceneFirst luceneFirst = new LuceneFirst();
        try {
            luceneFirst.chinaTokenStreamTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() throws Exception{
        MMSegAnalyzer analyzer = new MMSegAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream("", "对几种中文分析器，从分词准确性和效率两方面进行比较");
        CharTermAttribute cta = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            System.out.println("[" + cta.toString() + "]");
        }

//        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();


    }


    @Test
    public void test6() {

    }

}
