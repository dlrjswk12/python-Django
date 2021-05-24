from django.contrib import admin
from blog.models import Post
#Post클래스가 Admin사이트에서 어떤 모습으로 보여줄지 정의
@admin.register(Post)
class PostAdmin(admin.ModelAdmin): 
    list_display  = ('id', 'title', 'modify_dt') 
    list_filter   = ('modify_dt',) 
    search_fields = ('title', 'content') 
    prepopulated_fields = {'slug': ('title',)}
    
#admin.site.register(Post) 