package com.facebook.android.utils;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.facebook.android.R;
import com.socialin.android.util.DialogUtils;

public class FacebookUtils {
	
	public static void showNoNetworkDialog(final Activity activity) {
		DialogUtils.showNoNetworkDialog(activity, 
										R.string.gen_network_failed, 
										R.string.gen_network_enable_msg, 
										R.string.gen_network_settings, 
										R.string.gen_close, 
										android.R.drawable.ic_dialog_info);
	}
	
	
	public static void initWebView(final WebView webView) {
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setClickable(true);
		webView.setInitialScale(100);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.clearHistory();
		webView.clearFormData();
		webView.clearCache(true);
		
		webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
	}
	
	/*public static void initUserInfoView(final View view, final Activity activity, final String text, final String userId, final String meta) throws Exception{
		if(view == null) return;
		
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				final TextView textView = (TextView) view.findViewById(R.id.fb_user_name);
				textView.setText(text);
				
				final  WebView image = (WebView) view.findViewById(R.id.fb_user_image);
				image.getSettings().setJavaScriptEnabled(true);
				image.clearHistory();
				image.clearFormData();
				image.clearCache(true);
				image.clearView();
				image.removeAllViews();
				
				image.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
				
				final String imageUrl = "http://graph.facebook.com/"+userId+"/picture?type=square";
				
				final String innerHTML = "<html><head>"+meta+"</head><body style = \"padding:0px\" marginwidth=\"0\" marginheight=\"0\" leftmargin=\"0\" topmargin=\"0\">"
										+ "<div style=\"width:30px;height:30px;float:left;background-color:#dce0eb;background-repeat:no-repeat;background-position:center center;\""
										+ "<img src='"+ imageUrl + "' style=\"width:30px;height:30px;border:1px solid #fff;\" /></div>"
										+ "</body></html>";
				
				image.loadUrl("about:blank");
				image.loadData(innerHTML, "text/html", "utf-8");
			}
		});
	}
	
	public static float calculateImageSize(final Activity activity) {
		if(activity == null) return 0;
		
		float imageSize = 60;
	    double rightLine = 4.1;
	    
	    final DisplayMetrics displaymetrics = new DisplayMetrics();
	    activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		float displayWidth = displaymetrics.widthPixels;
		int imgCountInLine = 3;
		if(displayWidth > 320) {
			rightLine = 3.1;
		}
		if (displayWidth > 500) {
			imgCountInLine = (int) (displayWidth / 120);
			rightLine = 13.1;
		}
		
		imageSize = (float) ((displayWidth - rightLine) / imgCountInLine);
	    
	    return imageSize;
	}
	
	public static void initSocialinAdView(final Activity activity, final RelativeLayout adLayout) {
		adLayout.setVisibility(View.GONE);
	}
	
	public static void removeAccountFromFBAccounts(final Activity activity, JSONArray fbAccounts, final String accessToken) {
		final JsonPersister persister = new JsonPersister();
		// remove fb account from saved jsonPersister
     	if(fbAccounts.length() == 1) {
     		fbAccounts = new JSONArray();
     		persister.putJsonArrayForKey(activity, FacebookConstants.KEY_FB_ACCOUNTS, fbAccounts);
     	}
     	
     	if(fbAccounts.length() > 1) {
	     	try {
	     		final JSONArray newJsonArray = new JSONArray();
	     		final int arraySize = fbAccounts.length();
	     		for(int j = 0; j < arraySize; j++) {
	     			final JSONObject jsonObject = fbAccounts.getJSONObject(j);
	     			
	     			if(!(jsonObject.getString(FacebookConstants.KEY_ACCESS_TOKEN).equals(accessToken))) {
	     				newJsonArray.put(jsonObject);
	     			}
	     			break;
	     		}
	     		persister.putJsonArrayForKey(activity, FacebookConstants.KEY_FB_ACCOUNTS, newJsonArray);
	     		fbAccounts = newJsonArray;
	     	} catch (Exception e) {
	     		e.printStackTrace();
	     	}
     	}
	}*/
}