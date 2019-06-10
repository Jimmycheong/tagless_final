# Understanding the 'tagless-final' approach 
Learning to use this to avoid committing to a particular 'Monad/Container' like 'Future'


## Overall Idea

1. We create Tagless-Final DSLs, which essentially contain a bunch of functions for a target monad 
2. One we implement this with a specific monad (e.g. Option, Future, etc.), we create an intepreter. 
3. This intepreter can then be pulled into the scope of a service which takes a target monad, as an implicit


In this way, the service does not need to worry about what type of monad happens underneath. This gives the
benefit of writing tests purely on a service level.

Resources: 
1. https://www.becompany.ch/en/blog/2018/06/21/tagless-final 