Important:
The "resources" directory must be added to the project's build path as a source
code directory. The project's resource bundles are placed here.

The project's name is "Exercise 4 - h145157". This is hardcoded into the JSP
files everywhere that uses an URL. I would change the code to remedy this, but
having met all the actual requirements of the assignment I've frankly run out
of patience with Java, and have decided I don't want to deal with it.

Other notes:
The FileModel class was written for when the program only needed to work in a
terminal. Java servlets, however, are literally incapable of loading files by
relative paths, so I couldn't use those models. Hence, those files are now
essentially dead code, but since they were used for an early stage of the
assignment I left them in.