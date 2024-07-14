class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack=[{}]
        i=0
        while i<len(formula):
            if formula[i]=='(':
                stack.append({})
                i=i+1
            elif formula[i]==')':
                top=stack.pop()
                i=i+1
                start_idx=i
                multiplier=1
                while i<len(formula) and formula[i].isdigit():
                    i=i+1
                multiplier=int(formula[start_idx:i] or 1)
                # merge now with the current top layer
                for element,count in top.items():
                    stack[-1][element]=stack[-1].get(element,0)+count*multiplier
            else:
                start_idx=i
                i=i+1
                while i<len(formula) and formula[i].islower():
                    i=i+1
                curr_formula=formula[start_idx:i]
                # reset the index for count
                start_idx=i
                while i<len(formula) and formula[i].isdigit():
                    i=i+1
                count=int(formula[start_idx:i] or 1)
                
                stack[-1][curr_formula]=stack[-1].get(curr_formula,0)+count
        # print(stack)
        stack_top=stack.pop()
        list_keys=list(stack_top.keys())
        list_keys.sort()
        # stack={i:stack_top[i] for i in list_keys}
        res=''
        for key in list_keys:
            if stack_top[key]==1:
                res=res+key
            else:
                res=res+(key+''+str(stack_top[key]))

        return res 
                
                
                
                

            
        