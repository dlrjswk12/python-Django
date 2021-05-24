from django.urls import path,re_path
from bookmark import views

app_name = 'bookmark' #네임스페이스
urlpatterns = [
    path('',views.BookmarkLV.as_view(), name='index'),
    path('<int:pk>/', views.BookmarkDV.as_view(), name='detail'),
    #re_path(r'^bookmark/(?P<title>[-\w]+)/$', BookmarkDV.as_view(), name='bookmark_detail'),
    #11장 추가내용 
    # Example: /bookmark/add/
    path('add/',
         views.BookmarkCreateView.as_view(), name="add",
    ),

    # Example: /bookmark/change/
    path('change/',
         views.BookmarkChangeLV.as_view(), name="change",
    ),

    # Example: /bookmark/99/update/
    path('<int:pk>/update/',
         views.BookmarkUpdateView.as_view(), name="update",
    ),

    # Example: /bookmark/99/delete/
    path('<int:pk>/delete/',
         views.BookmarkDeleteView.as_view(), name="delete",
    ),
    
    
    
    
]
