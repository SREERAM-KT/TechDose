class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        parentheses = {'[': ']', '{': '}', '(': ')'}

        for item in s:
	        if item not in parentheses:
		        if stack:
			        if parentheses[stack[-1]] == item:
				         stack.pop()
			        else:
				        return False
		        else:
			        return False
	        else:
		        stack.append(item)
        return not stack