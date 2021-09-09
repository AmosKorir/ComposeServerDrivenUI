# Jetpack Compose Server Driven UI
**Server Driven UI**

This is a demo application for a session at Safaricom to demostrate Server driven  UI using  Jetpack Compose.

**How it works,**

The UI changes depending on the api response, which makes dynamic.

**Used libraries**

1. Koin -Dependency Injection
2. Retrofit
3. Okhttp
4. RxJava



<table>
<tr>
<td>
<img  width="200" height="400" src="https://github.com/AmosKorir/ComposeServerDrivenUI/blob/main/arts/i.jpeg"/>
</td>
</tr>
</table>


**Example of example server response**



 ```json
  {
    "view_type": "column",
    "content": [
        {
            "vertical_padding":12,
            "horizontal_padding":16,
            "view_type": "bigCard",
            "data": {
                "title": "B-Card",
                "description":"this a sample description for the card "
            }
        },
        {
            "vertical_padding":2,
            "horizontal_padding":4,
            "view_type": "row",
            "content":[
                            {
                                "vertical_padding":2,
                                "horizontal_padding":4,
                                "view_type": "buttonCard",
                                "data": {
                                    "title": "M-pay"
                                }
                            } ,
                             {
                                "vertical_padding":2,
                                "horizontal_padding":4,
                                "view_type": "buttonCard",
                                "data": {
                                    "title": "Setting"
                                }
                            },
                             {
                                "vertical_padding":2,
                                "horizontal_padding":4,
                                "view_type": "buttonCard",
                                "data": {
                                    "title": "Loan"
                                }
                            }          
            ],
            "data": {
                "title": "Pay Now"
            }
        },
        {
            "vertical_padding":2,
            "horizontal_padding":4,
            "view_type": "buttonCard",
            "data": {
                "title": "Yoh!"
            }
        },
        
        {
            "vertical_padding":2,
            "horizontal_padding":4,
            "view_type": "buttonCard",
            "data": {
                "title": "Loan"
            }
        }
    ]
}
  ```
        
        
        
        
