from django.db import models
from django.urls import reverse
from django.contrib.auth.models import User
class Bookmark(models.Model):
    # 묵시적으로 id가 프라이머리 키로 자동증가되는 필드가 만들어 진다. 
    title = models.CharField('TITLE',max_length=100,blank=True)
    url = models.URLField('URL',unique=True)
    owner = models.ForeignKey(User,on_delete=models.CASCADE,blank= True,null = True,)
    
    class Meta:
        verbose_name = 'bookmark'
        verbose_name_plural = 'bookmarks'
        db_table = 'bookmark_bookmark'
        ordering = ('title',)

    def __str__(self):
        return self.title
    
    def get_absolute_url(self):
        return reverse('bookmark:bookmark_detail', args=(self.title,))
    
    def get_previous(self):
        return self.get_previous_by_title()
    def get_next(self):
        return self.get_next_by_title()