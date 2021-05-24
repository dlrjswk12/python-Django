from django.apps import AppConfig

# 해당 애플리케이션에 대한 메타정보를 저장하기 위한 클래스
# 이것을 '애플리케이션설정클래스' 라고함
class BookmarkConfig(AppConfig):
    # 앱이름(name)--필수 
    # 레이블(label)
    # 별칭(verbose_name) 
    # 경로(path) 
    name = 'bookmark'
