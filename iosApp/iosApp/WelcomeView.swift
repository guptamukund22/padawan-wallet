//
//  WelcomeView.swift
//  iosApp
//
//  Created by geigerzaehler on 2024-01-13.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct WelcomeView: View {
    
    @Environment(\.dismiss) var dismiss
    @State private var isPresentedRecoverView = false
    
    var body: some View {
        
        VStack {
            
            Image("logo")
                .resizable()
                .scaledToFill() // add if you need
                .frame(width: 100.0, height: 100.0)
                .clipped()
            Spacer()
                    
            Text("Padawan Wallet")
                .bold()
                .font(/*@START_MENU_TOKEN@*/.title/*@END_MENU_TOKEN@*/)
            Spacer()
            
            Text("Welcome to Padawan!\n\nThis application is a place to learn the common features of mobile bitcoin wallets.\n\nIt uses bitcoin\'s _**testnet**_, an alternative bitcoin network used globally and built exclusively for testing. The coins on this network do not have any value, but they otherwise look and behave just like normal bitcoins!\n\nThis wallet is built for users of all ages to experiment and learn about bitcoin in a risk-free environment.")
            
            Spacer()
            Button(action: {
                //TODO create a new wallet!
                dismiss()
            }, label: {
                Text("Create a wallet")
            })
                    //.font(.system(size: 16, design: .monospaced))
                    .font(.title)
                    .fontWeight(.bold)
                    .frame(maxWidth: .infinity, maxHeight: 40)
                    .foregroundColor(Color.white)
                    .padding(10)
                    .background(Color.orange)
                    .cornerRadius(20)
                    //.shadow(color: Color("Shadow"), radius: 1, x: 5, y: 5)
            
            Spacer(minLength: 50)
            HStack {
                Text("I already have a wallet?")
                Spacer()
                Button(action: {
                    isPresentedRecoverView = true
                }, label: {
                    Text("Recover it Here")
                })
                .fullScreenCover(isPresented: $isPresentedRecoverView, content: {
                    RecoverView()
                })
            }
            
            Spacer()
        }.padding(40)
    }
}

#Preview {
    WelcomeView()
}