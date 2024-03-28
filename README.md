# 2024年2月頃作成開始

## 目的
業務上、フレームワークを使用せずにJAVAでWEBアプリケーションを作る必要があり、学習用としてリポジトリを作成することにした。
インフラ環境も含め、構築から公開まで学習する。

### TODO1 
JAVAで簡易的なWEBショップアプリを開発(MVCモデル)。

### TODO2
LinuxではなくWindowsServerを利用するため、WindowsServerにてインフラ環境を構築し、公開する(金銭的な理由によりVPS環境を利用)。

### TODO3
TODO2構築後、クラウド(AWS)環境で構築、公開。  
「(WEB/AP)(DB)」の二層構成を予定。

----------------------------------------------

## TODO1完了(2024年2月9日)
簡易的なWEBショップアプリを開発完了。
テストや改良は TODO3 が完了次第、改めて行う。

## TODO2完了(2024年02月23日) 
VPS環境にでWEBアプリを公開。
　




  
※追記(2024年03月17日)　　

　サクラVPSに異なるサーバーを接続するサービスがあった為、AWSより先に「(WEB/AP)(DB)」の二層での環境構築をVPSでテストした。　　
 

　以下、同じDBサーバーを使用している ***(PostgreSQL)***。　　

   

***・WindowsServer (IIS/WildFly)***  
 
https://win.oboegaki-vps.com/TODO-1-No1/login.jsp
     
***・Linuxの場合(Apache/Wildfly)***  
  
https://linux.oboegaki-vps.com/TODO-1-No1/login.jsp

___
※一つのドメインで、複数のサイトを動作させることが可能であることを確認した(リバースプロキシ使用)。  
今後はGitHubだけでなく、ワードプレスを備忘録用に併用する。  



https://linux.oboegaki-vps.com/wp/?p=2812
___

## TODO3完了(2024年03月28日) 
AWS環境でWEBアプリを公開。  

https://oboegak-cloud.com/TODO-1-No1/login.jsp  

***NextTodo:***  
AWS構築手順を整理して資料にまとめる(OSイメージはwindows Server)。    
学習が終わり次第、AWSのサービスを停止し、以降はVPSで学習を行う。

