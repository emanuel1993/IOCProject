# IOCProject

# Existing sites which implement an idea similar to ours:
- http://www.missingx.com/
- https://mylostbox.com/
- https://www.lostandfound.com/
- http://www.brighthubengineering.com/seafaring/38464-different-types-of-searches-or-search-patterns/
- https://www.missionmanager.com/


# Nume echipa: 
- CEJAN

# Membrii (toti de la grupa 342 C4):
- Antonache Emanuel, antonacheemanuel2007@gmail.com
- Jalba Cristian, jalba.cristian0493@gmail.com
- Neagu Constantin, constantin.neagu.office@gmail.com

# Tema proiect: 
- An online platform with the purpose of posting announcements of missing people, animals or even objects.

# Motivatie alegere tema: 
- Newspaper lost/found articles are not interactive 
- they offer you little opportunity to interact with the members of search effort, and also coordinate and monitor the status of the mission
- they are hard to update
- same about posters or flyers
- all the platforms are too static for our point of view
- a platform to coordinate the search efforts for the community in real time
1. we wanted to implement a GPS System, but decided not to due to lack of experience and hardware cost (real time team search mostly impossible to do)
2. we want to implement a map with grid where we can send people to different locations using flags, and people have to prove by taking a photo that a location was searched;
3,12. users will have a rating based on progress (success rate) and also a user profile where it sais various details about the person (user rating system + user profile with information about useful skills and equipment)
4. on zones with no GSM signal, we need but can't implement a routing algorithm on hardware for message relaying --> lack of hardware resources, much software development time etc.
5. aerial drone support is impossible -> call drone to the person which wants to see a certain locations which he doesn't have access to; once the drone sees the target, should automatically follow it -> hard to implement
6. a payment system based on results, which will be done in the future
7. already existing lost and found projects which offer team management are expensive; we want to develop something free and efficient
8. a device inserted into objects or in items worn by humans/animals, with the help of whom we can track them real-time
9. a user friendly platform, as all the existing platforms can't maintain an equilibre between functionality and easy of use
10. a worldwide system, available for any country
11. integration with state/private institutes
13. every person can come with its own equipments, which will be put together in a pool of assets that can be distributes to the most suited team members, also tracked and made sure they are not misplaced and used at the 
full pottential
14. image based target indentification service based on byometric signatures (a person who found something will take a picture, and if that picture looks like a missing object, it's ok)
15. difficulty: reward system hard to implement because we have to reward not only the person who found the object, but the whole team, based on their actualt contribution to the progress

# Tehnologii folosite:
- Java for backend, version 8 update 60 - https://java.com/en/download/
- Hibernate, version 5.0.2 final - http://hibernate.org/orm/
- MySQL Community Server version 5.6.27 - http://dev.mysql.com/downloads/mysql/
- STRUTS 2 version 2.3.24.1 GA - https://struts.apache.org/
- Apache Tomcat version 8.0.28 - http://tomcat.apache.org/download-80.cgi

Toate aceste tehnologii mentionate sunt gratuite, iar unele sunt open source.

# IDE:
- Eclipse EE Mars (4.5) - https://eclipse.org/downloads/ 

# Platforma hardware:
- Amazon Web Services - https://aws.amazon.com/

# Mod de lucru:
- o sa avem fiecare o instanta locala a interfetei, prin care ne conectam la baza de date de pe Amazon