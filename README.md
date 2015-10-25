# IOCProject

# Existing sites which implement an idea similar to ours:
- http://www.missingx.com/
- https://mylostbox.com/
- https://www.lostandfound.com/
- http://www.brighthubengineering.com/seafaring/38464-different-types-of-searches-or-search-patterns/
- https://www.missionmanager.com/


# Team Name:
- CMT (Coding Master Team)

# Members:
- Antonache Emanuel Adrian, 342 C4, antonacheemanuel2007@gmail.com
- Cretan Andrada Bianca, bianca.andrada.cretan@gmail.com
- Jalba Cristian, 342 C4, jalba.cristian0493@gmail.com
- Neagu Constantin, 342 C4, constantin.neagu.office@gmail.com

# Project theme:
- An online system that can assist individuals in finding missing people, animals or objects by providing specific tools in order to efficiently distribute the effort among all the volunteers or stakeholders.

# Motivation:
  The search & rescue/recovery sector is not something that many people care about on a daily basis. Depending on the magnitude of the loss, people either go to the local authorities or use one of the classical lost and found outlets (newspapers, lamp posts, various other public areas (including Facebook), dedicated departments that some institutions are providing for such a scope, etc.). Looking at incidents from the bottom of the magnitude scale, the methods available have a relatively limited reach, allow for little bidirectional feedback and knowledge buildup (a mandatory feature if one can hope at an intelligent system). At this level, people should not be worried (so much) about valuables forgotten in public transport or stolen goods, because they have a way of reporting the loss. By doing so, the individual who finds the items in questions can quickly get in touch with the rightful owner, and the thief is strongly discouraged to valorify the capture, because it is blacklisted in a accessible place. This approach will contribute in the prevention of robberies especially for portable electronic devices that have a lot of identification information embedded (IMEI, Serial Numbers, License numbers, etc.), but not only (cars, motorcycles, tools and equipment, etc.).
  Moving up the magnitude scale of the incident, pet recovery can be vastly improved by organizing and managing a search mission with volunteers, empowered by a platform that can provide geographical and situational awareness, in order to maximize the chances of a positive outcome. All the previously mentioned observations also apply to pets.
  A similar approach can be employed when we are talking about missing humans. Although in such cases the full implication of specialized institutions in a given, it is not always the case or the efficiency is questionable. Less developed regions have a low chance of having a motivated, well trained, fully equipped search and rescue force. Volunteers are used quite frequently in order to complement the professionals.
  In the most fortunate of cases the specialists will use some sort of system in order to properly manage the mission, however it is very hard to
  integrate the volunteers into it, because of various considerations. The interface between the two types of teams can be vastly improved by a
  readily available platform that has the necessary functionality to track and organize the volunteer activity. There is quite often the case for a search operation to continue even after the authorities have retreated, and we can say that the value of the system is growing fantastically in such a scenario, because advanced mission management systems are very expensive, hard to use and lack the all important social interactivity that can be crucial for a loosely coupled team.

1. Such a platform should have a certain level of integration with the GPS System, but the challenges in implementing such a feature are pretty high.
2. Using a map divided into sectors (a grid basically) and relying on personal position reporting should suffice for a case study.  
3. Volunteers (or not, aka people that do the searching for the reward) should have a rating based on success rate.
4. Volunteers should have a profile with various details about the useful skills and/or equipment the person might have.
5. In zones with no GSM signal, a multi-hop message passing protocol would be very useful in order to ensure that every member of the team remains reachable.
6. The possibility of allowing aerial support via drones. One could call in a drone to get a better perspective of the area/location.
7. In the case where the search effort is financially motivated, there should be a way of rewarding the participants based on involvement.
8. Existing lost and found projects which offer team management are expensive; we want to develop something free and efficient.
9. Integration with wearable devices that can inserted into objects or in items worn by humans/animals, with the help of which we can benefit of real-time tracking.
10. User friendly platform, as all the existing solutions do not maintain an equilibrium between functionality and accessibility.
11. For best results this should be a worldwide system, available in every region.
12. And it should be acknowledged and used by state/private institutes.
13. Participants can come with their own equipment, which can be put together in a pool of assets and can then be distributed to the most suited team members with the help of the system. The equipment can also be tracked and made sure it is not misplaced.
14. Image based identification capabilities (a person who found something will take a picture, and the system can decide if it's a lost object or pet).
15. Biometrics based identification capabilities, for those situations when we are dealing with missing humans.

# Images used to 
1. newspaperads.png - as we can see, the newspaper is inefficient and offers little information, and in case we want more information, 
we have to send a mail, or contact them via telephone, or even go to their house (which happens in this very example).
2. missionmanagerdotcomprices.png - depicts the fact that professional systems are too expensive for the casual user and allow for a very small network.
3. lostandfound.png - depiction of limited functionality in an unorganised manner.

# Proposed technologies:
- Java for backend, version 8 update 60 - https://java.com/en/download/
- Hibernate, version 5.0.2 final - http://hibernate.org/orm/
- MySQL Community Server version 5.6.27 - http://dev.mysql.com/downloads/mysql/
- STRUTS 2 version 2.3.24.1 GA - https://struts.apache.org/
- Apache Tomcat version 8.0.28 - http://tomcat.apache.org/download-80.cgi

All of these technologies are free and some are also open source.

# IDE:
- Eclipse EE Mars (4.5) - https://eclipse.org/downloads/

# Hardware Platform:
- Amazon Web Services - EC2 tiny-instance (CPU 1 GHz - 1 core, RAM 1 GB, SSD 25 GB).

# Workflow:
- Local interface instances, remote unique database instance.
