from django.contrib import admin
from bookmark.models import Bookmark
# Register your models here.
@admin.register(Bookmark) #------------------(1)
class BookmarkAdmin(admin.ModelAdmin):
    list_display =('id','title','url')
 
#admin.site.register(Bookmark,BookmarkAdmin) #--------(2)   

# 위 (1), (2) 중 한 방법을 적용 
# 하나의 테이블이 새로인 만들어 질려면 models.py 와 aqdmin.py 두개 파일이 수정되어야 함