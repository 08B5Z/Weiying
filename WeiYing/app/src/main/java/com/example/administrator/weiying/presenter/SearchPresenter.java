package com.example.administrator.weiying.presenter;

import com.example.administrator.weiying.model.SearchModel;
import com.example.administrator.weiying.model.bean.SearchBean;
import com.example.administrator.weiying.view.SearchView;

/**
 * Created by Administrator on 2017/12/15.
 */

public class SearchPresenter {

    private SearchView searchView;
    private final SearchModel searchModel;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
        searchModel = new SearchModel();
    }

    public void getFindPresneter(){
        String keyword = searchView.getKeyword();
        searchModel.getSearchData(keyword);
        searchModel.setOnSearchListener(new SearchModel.OnSearchListener() {
            @Override
            public void onSuccess(SearchBean searchBean) {
                searchView.getSearchView(searchBean);
            }
        });
    }
}
