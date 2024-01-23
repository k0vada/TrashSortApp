package com.example.trashsortapp

var sortRuleList = mutableListOf<SortRule>()
val SORT_RULE_ID_EXTRA = "sortRuleExtra"
class SortRule (
    var container: Int,  // будет указывать на ресурс изображения
    var type: String,    //Тип сортировки (в какой контейнер класть)
    var description: String,
    var newThings: String,
    var id: Int? = sortRuleList.size
)



