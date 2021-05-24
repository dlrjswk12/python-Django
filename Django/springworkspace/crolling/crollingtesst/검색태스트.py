'''
Created on 2019. 10. 31.
네이버 블로그를 크롤링하여 파일로 저장하는 프로그램 
@author: Teacher
'''



import csv 
from urllib.request import urlopen 
from urllib.parse import quote_plus 
from bs4 import BeautifulSoup 


# 크롤링한 데이타를 csv 파일로 만들기 


def search():
    search = input('검색어 입력:')
    fileName = input('저장파일명:')
    url = f'https://m.search.naver.com/search.naver?where=m_view&sm=mtb_jum&query={quote_plus(search)}'
    html = urlopen(url).read() 
    soup =  BeautifulSoup(html,'html.parser')
    total = soup.select('.api_txt_lines.total_tit')
    
    with open(fileName,'a',encoding="utf-8") as f: 
        for i in total:
            f.writelines(i.text)
            print(i.text)
            f.writelines(i.attrs['href'])
            print(i.attrs['href'])
            f.writelines('\n')
            print()
           
if __name__ == '__main__':
    search()
    print("done Good~~")