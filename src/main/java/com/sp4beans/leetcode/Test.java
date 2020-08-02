package com.sp4beans.leetcode;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-05-13
 */
public class Test {

    private class InspectionArticleLogModel {
        private long articleId;

        public long getArticleId() {
            return articleId;
        }

        public void setArticleId(long articleId) {
            this.articleId = articleId;
        }
    }

    private class ArticleContentModel {
        private long articleId;

        public long getArticleId() {
            return articleId;
        }

        public void setArticleId(long articleId) {
            this.articleId = articleId;
        }
    }

    private class ArticleWarnMessageModel {
        private long articleId;

        public long getArticleId() {
            return articleId;
        }

        public void setArticleId(long articleId) {
            this.articleId = articleId;
        }
    }

    private class ArticleIndicatorsModel {
        private long articleId;

        public long getArticleId() {
            return articleId;
        }

        public void setArticleId(long articleId) {
            this.articleId = articleId;
        }
    }

    public static void main(String[] args) throws Exception {

        // 通过查询语句把这玩意搞出来
        List<InspectionArticleLogModel> articleLogModelList = queryLogModels();

        List<Long> articleIds = articleLogModelList.stream()
                .map(InspectionArticleLogModel::getArticleId)
                .distinct()
                .collect(Collectors.toList());

        // 假设这俩是一对一的
        Map<Long, ArticleContentModel> idToArticleContent = Maps.newHashMap();
        Map<Long, ArticleWarnMessageModel> idToArticleWarnMessage = Maps.newHashMap();

        // 假设这玩意是一对多的
        Map<Long, List<ArticleIndicatorsModel>> idToArticleIndicators = Maps.newHashMap();

        // 读mysql的时候即使有索引 也别一次查大量id 一次查1000条 多查几次就完事了
        Lists.partition(articleIds, 1000).forEach(subList -> {
            idToArticleContent.putAll(
                    queryArticleContentsByIds(subList).stream()
                            .collect(Collectors.toMap(ArticleContentModel::getArticleId, Function.identity(), (a, b) -> b))
            );

            idToArticleWarnMessage.putAll(
                    queryArticleWarnMessageByIds(subList).stream()
                            .collect(Collectors.toMap(ArticleWarnMessageModel::getArticleId, Function.identity(), (a, b) -> b))
            );

            idToArticleIndicators.putAll(
                    queryArticleIndicatorsByIds(subList).stream()
                            .collect(Collectors.groupingBy(ArticleIndicatorsModel::getArticleId))
            );
        });

        // TODO 剩下的就是根据 articleLogModelList 拼结果了 不写了
    }

    private static List<InspectionArticleLogModel> queryLogModels() {
        // TODO do sth.
        return Lists.newArrayList();
    }

    private static List<ArticleContentModel> queryArticleContentsByIds(Collection<Long> articleIds) {
        // TODO do sth.
        return Lists.newArrayList();
    }

    private static List<ArticleWarnMessageModel> queryArticleWarnMessageByIds(Collection<Long> articleIds) {
        // TODO do sth.
        return Lists.newArrayList();
    }

    private static List<ArticleIndicatorsModel> queryArticleIndicatorsByIds(Collection<Long> articleIds) {
        // TODO do sth.
        return Lists.newArrayList();
    }

}

